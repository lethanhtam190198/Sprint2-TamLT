// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api/public/books',
  apiUrl1: 'http://localhost:8080/api/public/customer',
  firebaseConfig: {
    apiKey: 'AIzaSyBZw5vWnnWTzw6A5VmxDWC0Q-VYf3ArtLQ',
    authDomain: 'bookstore2-59004.firebaseapp.com',
    databaseURL: 'https://bookstore2-59004-default-rtdb.asia-southeast1.firebasedatabase.app',
    projectId: 'bookstore2-59004',
    storageBucket: 'bookstore2-59004.appspot.com',
    messagingSenderId: '967154108733',
    appId: '1:967154108733:web:cf2dc67719441c0f449d54',
    measurementId: 'G-2DB59CEH09'
  }
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
