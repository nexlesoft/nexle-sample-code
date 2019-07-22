package com.core.suite;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import com.core.gurock.testrail.APIException;
import com.core.test.sportstg.ActionLog.TC043_ActionLog_PageLoad;
import com.core.test.sportstg.ActionLog.TC044_ActionLog_ChangePeriod;
import com.core.test.sportstg.ActionLog.TC045_ActionLog_ChangeScore;
import com.core.test.sportstg.ActionLog.TC046_ActionLog_ChangeFoul;
import com.core.test.sportstg.ActionLog.TC047_ActionLog_ReassignScore;
import com.core.test.sportstg.ActionLog.TC048_ActionLog_ReassignFoul;
import com.core.test.sportstg.ActionLog.TC049_ActionLong_SetTimeoutAnotherTeam;
import com.core.test.sportstg.ActionLog.TC050_ActionLog_UndoLastAction;
import com.core.test.sportstg.ActionLog.TC051_ActionLog_Redo;
import com.core.test.sportstg.GameList.TC005_GameList_PageLoadedByDefault;
import com.core.test.sportstg.GameList.TC006_GameList_ChangeDateFromDropDownList;
import com.core.test.sportstg.GameList.TC007_GameList_ManualSyncOfAdmin;
import com.core.test.sportstg.GameList.TC008_GameList_ExportGameFile;
import com.core.test.sportstg.GameList.TC009_GameList_ClearDataFromSettings;
import com.core.test.sportstg.GameList.TC010_GameList_NoGameToSync;
import com.core.test.sportstg.GameList.TC011_GameList_NoGameToEmail;
import com.core.test.sportstg.GameTime.TC020_GameTime_PageLoad;
import com.core.test.sportstg.GameTime.TC021_GameTime_AddScoreToPlayer;
import com.core.test.sportstg.GameTime.TC022_GameTime_AddScoreToTeam;
import com.core.test.sportstg.GameTime.TC023_GameTime_SetTimeoutToTeam;
import com.core.test.sportstg.GameTime.TC024_GameTime_SetFoulToPlayer;
import com.core.test.sportstg.GameTime.TC025_GameTime_SetTechnicalFoulToPlayer;
import com.core.test.sportstg.GameTime.TC026_GameTime_SetTechnicalFoulToTeam;
import com.core.test.sportstg.GameTime.TC027_GameTime_SetTechnicalFoulToCoach;
import com.core.test.sportstg.GameTime.TC028_GameTime_SetUnsportmanlikeFoulToPlayer;
import com.core.test.sportstg.GameTime.TC029_GameTime_SetDisqualifiedFoulToPlayer;
import com.core.test.sportstg.GameTime.TC030_GameTime_StartP1Clock;
import com.core.test.sportstg.GameTime.TC031_GameTime_EditClock;
import com.core.test.sportstg.GameTime.TC032_GameTime_ConfirmGame;
import com.core.test.sportstg.GameTime.TC033_GameTime_InjuryReport;
import com.core.test.sportstg.GameTime.TC034_GameTime_IncidentReport;
import com.core.test.sportstg.GameTime.TC035_GameTime_Forfeit;
import com.core.test.sportstg.GameTime.TC036_GameTime_EditTeam;
import com.core.test.sportstg.GameTime.TC037_GameTime_BackToGameList;
import com.core.test.sportstg.GameTime.TC038_GameTime_UndoLast;
import com.core.test.sportstg.GameTime.TC039_GameTime_Redo;
import com.core.test.sportstg.GameTime.TC040_GameTime_SetTwoTechnicalFoulToCoachToBeDisqualified;
import com.core.test.sportstg.GameTime.TC041_GameTime_SetThreeTechnicalFoulToTeam;
import com.core.test.sportstg.GameTime.TC042_GameTime_SetTwoTechnicalFoulToTeamAndOneToCoach;
import com.core.test.sportstg.Login.TC001_Login_ClickChangeLink;
import com.core.test.sportstg.Login.TC002_Login_PressEnterKey;
import com.core.test.sportstg.Login.TC003_Login_ChangeToAnotherCourt;
import com.core.test.sportstg.Login.TC004_Login_LoginWithWrongData;
import com.core.test.sportstg.TeamSelectionList.TC012_TeamSelectionList_PageLoad;
import com.core.test.sportstg.TeamSelectionList.TC013_TeamSelectionList_SelectPlayersFromTeamList;
import com.core.test.sportstg.TeamSelectionList.TC014_TeamSelectionList_RemovePlayersFromPlayingInThisGame;
import com.core.test.sportstg.TeamSelectionList.TC015_TeamSelectionList_AddNewCoach;
import com.core.test.sportstg.TeamSelectionList.TC016_TeamSelectionList_RemoveCoach;
import com.core.test.sportstg.TeamSelectionList.TC017_TeamSelectionList_EditTeamColor;
import com.core.test.sportstg.TeamSelectionList.TC018_TeamSelectionList_BackToGameList;
import com.core.test.sportstg.TeamSelectionList.TC019_TeamSelectionList_ChooseAnotherTeam;
import com.core.test.sportstg.TeamSelectionList.TC052_TeamSelectionList_SearchMemberWithInvalidData;
import com.core.test.sportstg.TeamSelectionList.TC053_TeamSelectionList_TapRefreshButton;
import com.core.utilities.util_TestRail;
import com.core.utilities.Category.Regression;


@RunWith(Categories.class)
@IncludeCategory(Regression.class)
@SuiteClasses({
	TC001_Login_ClickChangeLink.class,
	TC002_Login_PressEnterKey.class,
	TC003_Login_ChangeToAnotherCourt.class,
	TC004_Login_LoginWithWrongData.class,
	TC005_GameList_PageLoadedByDefault.class,
	//TC006_GameList_ChangeDateFromDropDownList.class,
	TC007_GameList_ManualSyncOfAdmin.class,
	TC008_GameList_ExportGameFile.class,
	TC009_GameList_ClearDataFromSettings.class,
	TC010_GameList_NoGameToSync.class,
	TC011_GameList_NoGameToEmail.class,
	TC012_TeamSelectionList_PageLoad.class,
	TC013_TeamSelectionList_SelectPlayersFromTeamList.class,
	TC014_TeamSelectionList_RemovePlayersFromPlayingInThisGame.class,
	TC015_TeamSelectionList_AddNewCoach.class,
	TC016_TeamSelectionList_RemoveCoach.class,
	TC017_TeamSelectionList_EditTeamColor.class,
	TC018_TeamSelectionList_BackToGameList.class,
	TC019_TeamSelectionList_ChooseAnotherTeam.class,
	TC020_GameTime_PageLoad.class,
	TC021_GameTime_AddScoreToPlayer.class,
	TC022_GameTime_AddScoreToTeam.class,
	TC023_GameTime_SetTimeoutToTeam.class,
	TC024_GameTime_SetFoulToPlayer.class,
	TC025_GameTime_SetTechnicalFoulToPlayer.class,
	TC026_GameTime_SetTechnicalFoulToTeam.class,
	TC027_GameTime_SetTechnicalFoulToCoach.class,
	TC028_GameTime_SetUnsportmanlikeFoulToPlayer.class,
	TC029_GameTime_SetDisqualifiedFoulToPlayer.class,
	TC030_GameTime_StartP1Clock.class,
	TC031_GameTime_EditClock.class,
	TC032_GameTime_ConfirmGame.class,
	TC033_GameTime_InjuryReport.class,
	TC034_GameTime_IncidentReport.class,
	TC035_GameTime_Forfeit.class,
	TC036_GameTime_EditTeam.class,
	TC037_GameTime_BackToGameList.class,
	TC038_GameTime_UndoLast.class,
	TC039_GameTime_Redo.class,
	TC040_GameTime_SetTwoTechnicalFoulToCoachToBeDisqualified.class,
	TC041_GameTime_SetThreeTechnicalFoulToTeam.class,
	TC042_GameTime_SetTwoTechnicalFoulToTeamAndOneToCoach.class,
	TC043_ActionLog_PageLoad.class,
	TC044_ActionLog_ChangePeriod.class,
	TC045_ActionLog_ChangeScore.class,
	TC046_ActionLog_ChangeFoul.class,
	TC047_ActionLog_ReassignScore.class,
	TC048_ActionLog_ReassignFoul.class,
	TC049_ActionLong_SetTimeoutAnotherTeam.class,
	TC050_ActionLog_UndoLastAction.class,
	TC051_ActionLog_Redo.class,
	TC052_TeamSelectionList_SearchMemberWithInvalidData.class,
	TC053_TeamSelectionList_TapRefreshButton.class
	
	})

public class CategorySuite {
	
	@BeforeClass
	public static void addNewTestRun() throws MalformedURLException, IOException, APIException
	{
		util_TestRail.addNewTestRun("21");
	}	
}
