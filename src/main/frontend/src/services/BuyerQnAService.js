import axios from "axios";
import authHeader from "../util/authHeader";

const BUYER_QNA_API_BASE_URL = "http://localhost:8080/api/v1/buyer-qna";

class BuyerQnAService {
  postManyBuyerQnAs(buyerQnAs) {
    return axios.post(BUYER_QNA_API_BASE_URL + "/post/many", buyerQnAs, {
      headers: authHeader(),
    });
  }
}

export default new BuyerQnAService();