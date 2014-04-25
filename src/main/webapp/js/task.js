var taskManager = {
	// Initialisierung
	init: function() {
		$('#edittasks').on('pagebeforeshow', this.onLoad);
		$('#edittasks-save').click(this.onSave);
		$('#edittaskproperties').on('popupbeforeposition', this.prepareEditPropertiesPopup);
		$('#addtasknode').on('popupbeforeposition', this.prepareAddNodePopup);
		$('#taskpopup-editproperties-apply').click(this.onApplyProperties);
		$('#taskpopup-addnode-add').click(this.onAddNode);
		$('#taskpopup-deletenode-confirm').click(this.onConfirmDelete);
	},
	
	// Prepare Funktionen
	prepareEditPropertiesPopup: function(e) {
		//CHECK
		var selected = inspectionTree.getTaskNodeById(inspectionTree.taskTree.getSelectedNodes()[0].id);
		$('#taskpopup-properties-treeitem-name').val(selected.name);
		$('#taskpopup-properties-treeitem-author').val(selected.author);
		$('#taskpopup-properties-textarea-description').val(selected.description);
		$('#taskpopup-properties-treeitem-weight').val(selected.weight);
	},
	prepareAddNodePopup: function(e) {
		//CHECK
		$('#taskpopup-addnode-treeitem-name').val('');
		$('#taskpopup-addnode-textarea-description').val('');
		$('#taskpopup-addnode-treeitem-weight').val('1');
		$('#taskpopup-addnode-treeitem-author').val(inspectionClient.settings.userName);
		$('#taskpopup-addnode-select-type').val('Task').selectmenu('refresh', true);
	},
	
	// Event Handler
	onLoad: function(event, data) {
		//TODO
		$('.task-edit-path').text($.t('edittaskspage.chooseTask'));
		$('.tasknode-operation li a').addClass('ui-state-disabled');
		if(data.prevPage.attr('id') != 'edit') {
			// springe zurück auf edit und lade Daten neu, wenn ein Reload durchgeführt wird
			inspectionTree.loadData();
			$.mobile.back();
		}
	},
	onSave: function() {
		if(inspectionTree.unsavedChanges > 0) {
			inspectionTree.saveData();
		}
	},
	onApplyProperties: function() {
		//CHECK
		var selected = inspectionTree.getTaskNodeById(inspectionTree.taskTree.getSelectedNodes()[0].id);
		inspectionTree.updateTaskNode(selected.id, {
			name: $('#taskpopup-properties-treeitem-name').val(),
			author: $('#taskpopup-properties-treeitem-author').val(),
			description: $('#taskpopup-properties-textarea-description').val(),
			weight: parseInt($('#taskpopup-addnode-treeitem-weight').val(), 10)
		});
	},
	onAddNode: function() {
		//CHECK
		var selected = inspectionTree.taskTree.getSelectedNodes()[0];
		var type = $('#taskpopup-addnode-select-type').val();
		var dateArray = new Date().toISOString().substr(0,19).split('T');
		var data = new inspectionItem[type];
		data.name = $('#taskpopup-addnode-treeitem-name').val();
		data.description = $('#taskpopup-addnode-textarea-description').val();
		data.author = $('#taskpopup-addnode-treeitem-author').val();
		data.date = dateArray[0] + ' ' + dateArray[1];
		data.resourceIdentifier = inspectionTree.freeTaskIdentifier;
		data.weight = parseInt($('#taskpopup-addnode-treeitem-weight').val(), 10);
		inspectionTree.addNode(selected.id, data);
	},
	onConfirmDelete: function() {
		//CHECK
		var selected = inspectionTree.taskTree.getSelectedNodes()[0];
		inspectionTree.deleteTaskNode(selected.id);
	},
	onSelectNode: function(treeNode) {
		//TODO Ansicht Ändern, so dass Type-spezifische Optionen eingeblendet werden (kein Popup sondern unterhalb der Menü Buttons)
		$('.task-edit-path').text(inspectionTree.getNodePath(treeNode));
		$('.tasknode-operation li a').removeClass('ui-state-disabled');
		// Wenn Task Root
		if(treeNode.id == inspectionTree.currentTask) {
			$('#button-edit-taskproperties').addClass('ui-state-disabled');
			$('#button-delete-tasknode').addClass('ui-state-disabled');
		}
		else {
			if(treeNode.type != 'Task') {
				$('#button-add-tasknode').addClass('ui-state-disabled');
			} else if(treeNode.isParent) {
				$('#button-delete-tasknode').addClass('ui-state-disabled');
			}
		}
	}
};