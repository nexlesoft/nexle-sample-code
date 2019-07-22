import { StackNavigator, TabNavigator, TabBarBottom, DrawerNavigator } from 'react-navigation';

import getSlideFromRightTransition from './SlideFromRightTransition';
import { ScreenKey } from '../Constants';

import SplashScreen from '../Containers/SplashScreen';
import SignupScreen from '../Containers/SignupScreen';
import LoginScreen from '../Containers/LoginScreen';
import HomeScreen from '../Containers/HomeScreen';
import DrawerContainer from '../Containers/DrawerContainer';
import AScreen from '../Containers/AScreen';
import ADetailScreen from '../Containers/ADetailScreen';
import BScreen from '../Containers/BScreen';

const AStack = StackNavigator({
  [ScreenKey.A_SCREEN]: { screen: AScreen },
  [ScreenKey.A_SCREEN_DETAIL]: { screen: ADetailScreen },
}, {
    headerMode: 'none',
    // initialRouteName: 'Login',
    //   cardStyle: styles.card,
    transitionConfig: getSlideFromRightTransition,
    // mode: 'modal'
  }
)

const DrawerNav = DrawerNavigator({
  [ScreenKey.HOME_SCREEN]: {
    screen: HomeScreen,
  },
  [ScreenKey.A_STACK]: {
    screen: AStack,
  },
  [ScreenKey.B_SCREEN]: {
    screen: BScreen,
  },
}, {
    contentComponent: DrawerContainer // custom drawer
  });

const MainNav = StackNavigator({
  // [ScreenKey.LOGIN_STACK] : { screen: LoginStack },
  [ScreenKey.SPLASH_SCREEN]: { screen: SplashScreen },
  [ScreenKey.DRAWER_NAV]: { screen: DrawerNav },
  [ScreenKey.LOGIN_SCREEN]: { screen: LoginScreen },
  [ScreenKey.SIGNUP_SCREEN]: { screen: SignupScreen },

}, {
    headerMode: 'none',
    // initialRouteName: ScreenKey.SPLASH_SCREEN,
    //   cardStyle: styles.card,
    transitionConfig: getSlideFromRightTransition, // custom transition animation
    // mode: 'modal'
  }
)

export default MainNav;