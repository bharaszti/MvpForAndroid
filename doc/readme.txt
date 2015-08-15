Feature: Start applicatoin
---------------------------
* should_OpenMainView_When_AppStarted
    - add main activity

* should_ShowZeroPersonsInMainView_For_NoRecordsExist
    - presenter: get persons from model
    - view: update with persons list

* should_UpdateNumberOfPersonsInMainView_Wen_NewPersonCreated
    - presenter: refresh


Feature: New person
----------------------------
* should_OpenNewPersonViewFromMainView
    - add "new person" button to MainView
    - open NewPersonView

* should_CreateNewPersonAndReturnToMainView
    - model: new person

* should_RejectSavingInNewPersonView_For_EmptyName
    - model: validtion
    - presenter: error handling
    - view: error popup

* should_RejectSavingInNewPersonView_For_AlreadyExistingName
    - model: validtion


Feature: List persons
----------------------------
* should_OpenPersonsViewFromMainView
    - add "persons" button to MainView
    - open ListPersonsView
    - populate ListView with persons from model


Feature: Edit person
----------------------------
* should_OpenEditPersonViewFromPersonsView
    - add onClick listener to ListView
    - open EditPersonView

* should_LoadPersonIntoEditPersonView

* should_SavePersonAndReturnToMainView

* should_RejectSavingInEditPersonView_For_EmptyName

* should_RejectSavingInEditPersonView_For_AlreadyExistingName


Feature: Delete person
----------------------------
* should_OpenDeleteConfirmationDialogFromEditPersonView

* should_DeletePersonAfterConfirmationAndReturnToPersonsView
