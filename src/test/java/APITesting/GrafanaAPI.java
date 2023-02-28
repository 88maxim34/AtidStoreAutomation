package APITesting;

import extentions.APIActions;
import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(utilities.Listeners.class)
public class GrafanaAPI extends CommonOps {
    @Test(description = "Test01 : Get Team From Grafana")
    public void test01_verifyTeam() {
        response = APIActions.get("/api/teams/search");
        String myResult = APIActions.extractFromJSON(response, "teams[0].name");
        Verifications.verifyText(myResult, "Maxim");
    }

    @Test(description = "Test02 : Add Team And Verify")
    public void test02_addTeamAndVerify() {
        // Preparing the object to POST
        params.put("name", "Maxim4");
        params.put("email", "Maxim4@gmail.com");
        // Method - POST
        APIActions.post(params, "/api/teams");
        // Method - GET
        // We're making a GET call to receive the new team that was created
        response = APIActions.get("/api/teams/search");
        String myResult = APIActions.extractFromJSON(response, "teams[2].name");
        // Verify
        Verifications.verifyText(myResult, "Maxim4");
    }

    @Test(description = "Test03 : Update Team And Verify")
    public void test03_updateTeamAndVerify() {
        response = APIActions.get("/api/teams/search");
        String teamId = APIActions.extractFromJSON(response, "teams[2].id");
        params.put("name", "Updated name");
        params.put("email", "Updated@gmail.com");
        APIActions.put(params, "/api/teams/" + teamId);
    }

    @Test(description = "Test04 : Delete Team And Verify")
    public void test04_deleteTeamAndVerify() {
        response = APIActions.get("/api/teams/search");
        String teamId = APIActions.extractFromJSON(response, "teams[2].id");
        APIActions.delete(teamId);
        response = APIActions.get("/api/teams/search");
        String count = APIActions.extractFromJSON(response, "totalCount");
        Verifications.verifyText(count, "2");
    }
}
