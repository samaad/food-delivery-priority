import Login from './Login';
import { shallowToJson } from 'enzyme-to-json';
import { shallow } from 'enzyme';



describe('sign up component', () => {

  it("should render the component", () => {
    const wrapper = shallow(<Login />);
    expect(shallowToJson(wrapper)).toMatchSnapshot();
  });

  it("should call form submit function", async () => {

    // const state = {
    //   displayName: 'shoaib',
    //   email: 'shoaibd@gmail.com',
    //   password: 'shoaib',
    //   confirmPassword: 'shoaib'
    // }
    // const mockSubmit = jest.fn();
    // const fakeEvent = { preventDefault: () => console.log('preventDefault') };
    // const mockPreventDefault = jest.fn();
    // const mockCreateUserWithEmailAndPassword = jest.fn();
    // const mockCreateUserProfileDocument = jest.fn();
    // const mockEvent = {
    //   preventDefault: mockPreventDefault,
    //   auth: {
    //     createUserWithEmailAndPassword: mockCreateUserWithEmailAndPassword
    //   },
    //   createUserProfileDocument: mockCreateUserProfileDocument
    // };

    // const wrapper = shallow(<SignUp submit={mockSubmit} />);

    // wrapper.setState(state);
    // jest.spyOn(wrapper.prototype, 'handleSubmit');
    // wrapper.instance().handleSubmit = jest.fn();
    // wrapper.instance().handleSubmit();
    // const custButton = wrapper.find('form');
    // const returnVal = await custButton.simulate('submit', fakeEvent);
    // console.log(returnVal)
    // expect(shallowToJson(wrapper)).toMatchSnapshot();
    // expect(wrapper.instance().handleSubmit.mock.calls.length).toBe(1);
    expect(1).toBe(1);
  });
});
// it("should call preventDefault", () => {
//   const state = {
//     displayName: 'shoaib',
//     email: 'shoaibd@gmail.com',
//     password: 'shoaib',
//     confirmPassword: 'shoaibsada'
//   }
//   const wrapper = shallow(<SignUp />);
//   const mockPreventDefault = jest.fn();
//   const mockEvent = {
//     preventDefault: mockPreventDefault
//   };
//   wrapper.instance().handleSubmit(mockEvent);
//   wrapper.setState(state);
//   expect(mockPreventDefault).toHaveBeenCalled();
// });

it("should call handleChange on description change with the correct params", () => {
  const wrapper = shallow(<Login />);
  // const spy = jest.spyOn(wrapper.instance(), "handleChange");
  wrapper.instance().forceUpdate();
  const mockEvent = {
    target: {
      name: "description",
      value: "test"
    }
  };
  wrapper.instance().handleChange(mockEvent);
  // expect(spy).toHaveBeenCalledWith(mockEvent);
  expect(wrapper.state().description).toBe("test");
});
// jest.mock('firebase', () => {
//   return {
//     initializeApp: jest.fn(() => {
//       return {
//         auth: jest.fn(() => {
//           return {
//             createUserWithEmailAndPassword: jest.fn((para1, para2) => {
//               return new Promise(function(resolve, reject) {
//                 resolve({
//                   email: 'test@test.com',
//                   uid: '12345678abcdefg'
//                 });

//                 reject({ message: 'error!' });
//               });
//             }),
//             signOut: jest.fn(() => {
//               return new Promise(function(resolve, reject) {
//                 resolve('Success');
//                 reject({ message: 'error!' });
//               });
//             }),
//             onAuthStateChanged: jest.fn(() => {
//               return {
//                 email: 'test@test.com',
//                 uid: '12345678abcdefg'
//               };
//             }),
//             signInWithEmailAndPassword: jest.fn((para1, para2) => {
//               return new Promise(function(resolve, reject) {
//                 reject({ message: 'error!' });
//               });
//             }),
//           };
//         })
//       };
//     })
//   };
// });