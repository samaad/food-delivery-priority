import { createSelector } from 'reselect';


export const selectOreder = state => state.order;

export const selectCurrentPriorityOrderList = createSelector(
  [selectOreder],
  (order) => order.currentPriorityList
);

export const isAuthenticate = createSelector(
  [selectOreder],
  (order) => order.isAuthenticate
);

export const orderList = createSelector(
  [selectOreder],
  (order) => order.currentPriorityList
);
