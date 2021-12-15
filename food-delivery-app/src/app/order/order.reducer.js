import { OrderActionType } from "./order.types";

const INITIAL_STATE = {
  currentPriorityList: null,
  error: null,
  isLoading: false,
  isAuthenticate: false
};

const orderReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case OrderActionType.SET_CURRENT_PRIORITY_ORDER_LIST:
      return {
        ...state,
        currentPriorityList: action.payload,
        error: null,
      };
    case OrderActionType.ORDER_LIST_ERROR:
      return {
        ...state,
        error: action.payload,
        currentPriorityList: null,
        isAuthenticate: false
      };
    case OrderActionType.IS_LOADING:
      return {
        ...state,
        isLoading: action.payload
      };
    case OrderActionType.IS_AUTHENTICATE:
      return {
        ...state,
        isAuthenticate: action.payload
      };
    default:
      return state;
  }
}

export default orderReducer;