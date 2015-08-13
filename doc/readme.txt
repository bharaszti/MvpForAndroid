Feature: Start applicatoin
---------------------------
* should_OpenMainView_When_AppStarted
    - add main activity

* should_ShowNoPersonsHintInMainView_For_NoRecordsExist
    - presenter: get persons from model
    - view: update with persons list

Feature: New person
----------------------------
* should_OpenNewPersonViewFromMainView
    - add new button to MainView
    - open NewPersonView

* should_SaveNewMeasurementAndReturnToHomeView


Feature: Show latest measurement
----------------------------
* should_ShowLatestMeasurementInHomeView_Given_ExistingRecords


Feature: Use database
----------------------------
* should_InsertMeasurementToDatabase
* should_ReadAllMeasurementsFromDatabase


</spike>
=======================================

Feature: View all measurements
----------------------------
* should_OpenMeasurementsViewFromHomView


Feature: Maintain measurements
----------------------------
* should_OpenEditMeasurementViewFromMeasurementsView
* should_SaveModifiedMeasurementAndReturnToMeasurementsView
* should_DeleteSelectedMeasurementFromMeasurementsView


Feature: Persist measurements
----------------------------
* should_UpdateMeasurementInDatabase
* should_DeleteMeasurementFromDatabase



Feature: View monthly consumption data
Feature: View monthly consumption diagram

