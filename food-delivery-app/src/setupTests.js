import React from 'react';
import { configure } from 'enzyme';
import { mount, shallow, render } from 'enzyme';
import { mountToJson, shallowToJson, renderToJson } from 'enzyme-to-json';
import Adapter from 'enzyme-adapter-react-16';

global.React = React;
global.mount = mount;
global.shallow = shallow;
global.render = render;
global.mountToJson = mountToJson;
global.shallowToJson = shallowToJson;
global.renderToJson = renderToJson;

configure({ adapter: new Adapter() });
