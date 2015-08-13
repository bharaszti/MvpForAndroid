Feature: Start applicatoin
---------------------------
* should_OpenMainView_When_AppStarted
    - add main activity

* should_ShowZeroPersonsInMainView_For_NoRecordsExist
    - presenter: get persons from model
    - view: update with persons list

* should_UpdateNumberOfPersonsInMainView_Wen_NewPersonCreated

Feature: New person
----------------------------
* should_OpenNewPersonViewFromMainView
    - add new button to MainView
    - open NewPersonView

* should_CreateNewPersonAndReturnToMainView

* should_RejectSavingInNewPersonView_For_EmptyName

* should_RejectSavingInNewPersonView_For_AlreadyExistingName

