# react-native-geocoder

## Getting started

`$ yarn add https://github.com/rnaufal32/react-native-geocoder`

### Mostly automatic installation

`$ react-native link react-native-geocoder`

## Usage
```javascript
import NativeGeocoder from 'react-native-geocoder';

NativeGeocoder.getFullAddress(-6.8817, 108.4620, (message) => {
    this.setState({
    message
    });
});

```
