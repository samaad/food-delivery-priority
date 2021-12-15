import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { getPriorityOrderList } from '../app/order/order.action';
import { orderList } from '../app/order/order.selector';
import moment from 'moment';
const Layout = () => {
    const orders = useSelector(orderList);
    const dispatch = useDispatch();

    useEffect(() => {
      const interval = setInterval(() => {
        dispatch(getPriorityOrderList());
      }, 5000);
        
      return () => clearInterval(interval);

    }, [])

    return (
        <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Customer Type</th>
      <th scope="col">Delivery Status</th>
      <th scope="col">Expected time</th>
      <th scope="col">Time to Reach Destination</th>
    </tr>
  </thead>
  <tbody>
  {orders && orders.map(order => (
    <tr key={order.deliveryId}>
      <th scope="row">{order.deliveryId}</th>
      <th>{order.customerType}</th>
      <td>{order.deliveryStatus}</td>
      <td>{moment(order.expectedDeliveryTime).format('MM d YYYY, HH:mm:ss')}</td>
      <td>{moment(order.timeToReachDestination).format('MM d YYYY, HH:mm:ss')}</td>
      <td>{order.meanTimeToPrepareFood}</td>
    </tr>
  ))}
    
  </tbody>
</table>
    )
}

export default Layout;
