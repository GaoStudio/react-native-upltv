
# react-native-upltv

## Getting started

`$ npm install react-native-upltv --save`

### Mostly automatic installation

`$ react-native link react-native-upltv`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-upltv` and add `RNUpltv.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNUpltv.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNUpltvPackage;` to the imports at the top of the file
  - Add `new RNUpltvPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-upltv'
  	project(':react-native-upltv').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-upltv/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-upltv')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNUpltv.sln` in `node_modules/react-native-upltv/windows/RNUpltv.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Upltv.RNUpltv;` to the usings at the top of the file
  - Add `new RNUpltvPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNUpltv from 'react-native-upltv';

// TODO: What to do with the module?
RNUpltv;
```
  