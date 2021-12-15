import { OrderActionType } from "./order.types";
import httpCall from "../apiConfig";

export const doLogin = (username, password) => async dispatch => {
  dispatch(setLoading(true));
  try{
      const res = await httpCall.get(`/login`, {
        auth: {
          password,
          username
        }
      })
      if(res.data){
        sessionStorage.setItem("TOKEN", res.config.headers.Authorization)
        dispatch(setAuthenticate(true));
        dispatch(setLoading(false));
      }
  }
  catch(e){
      dispatch(setError(e))
      dispatch(setLoading(false));
  }
}

export const getPriorityOrderList = () => async dispatch => {
  dispatch(setLoading(true));
  try{
      const res = await httpCall.get(`/prioritylists`)
      if(res.data){
        dispatch(setCurrentPriorityOrderList(res.data));
        dispatch(setLoading(false));
      }
  }
  catch(e){
      dispatch(setError(e))
      dispatch(setLoading(false));
  }
}

export const setAuthenticate = auth => ({
  type: OrderActionType.IS_AUTHENTICATE,
  payload: auth
});


export const setError = e => ({
  type: OrderActionType.ORDER_LIST_ERROR,
  payload: e
});

export const setLoading = loading => ({
  type: OrderActionType.IS_LOADING,
  payload: loading
});

export const setCurrentPriorityOrderList = order => ({
  type: OrderActionType.SET_CURRENT_PRIORITY_ORDER_LIST,
  payload: order
});