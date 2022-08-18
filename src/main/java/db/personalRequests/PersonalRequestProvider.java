package db.personalRequests;

import static utils.DataFaker.faker;

import com.github.javafaker.DateAndTime;
import db.personalRequests.PersonalRequestsModel;

import java.util.Date;

public interface PersonalRequestProvider {

    public static void main(String[] args) {
        System.out.println(faker().number().digits(9));
        System.out.println(faker().date().birthday());
    }

    static PersonalRequestsModel fakeRequest(String personalNumber, Integer subType) {
        return new PersonalRequestsModel()
                .req_id(null)
                .personalNumber(personalNumber)
                .subType(subType)
                .beginningDate(faker().date().toString())
                .essenceRequest("still not know")
                .requestStatus("01")
                .requestStatusReason(null)
                .requestReasonSubmitting("still not know")
                .black_status("still not know")
                .hour("still not know")
                .red_timestamp(null)
                .red_counter(null)
                .send_to_red_status("1")
                .updated_time(null);

    }
}
