const pattern = [
    'src/components/**/*.js',
    'src/container/**/*.js',
    'src/app/**/*.js',
    'src/App.js',
  ];
  
  module.exports = {
    collectCoverageFrom: pattern,
    collectCoverage: true,
    coverageReporters: ['lcov', 'text'],
    snapshotSerializers: ["enzyme-to-json/serializer"],
    // coverageThreshold: {
    //   global:
    //   {
    //     statements: 95,
    //     branches: 90,
    //     functions: 90,
    //     lines: 95,
    //   },
    // },
    roots: [
      '<rootDir>/src',
    ],
    setupFiles: ['<rootDir>/src/setupTests.js'],
    testEnvironment: "node",
    errorOnDeprecated: true,
    moduleNameMapper: {
      "^.+\\.(css|less|scss)$": "babel-jest"
    },
    moduleFileExtensions: [
      "js",
      "jsx"
    ],
    coverageDirectory: './build/coverage/',
    reporters: [
      'default',
      [
        'jest-junit',
        {
          suiteName: 'Food Priority service',
          outputDirectory: './build/reports/test',
          outputName: './tests-report.xml',
          classNameTemplate: '{classname}-{title}',
          titleTemplate: '{classname}-{title}',
          ancestorSeparator: ' › ',
          usePathForSuiteName: 'true',
        },
      ],
      [
        'jest-html-reporters',
        {
          publicPath: './build/reports/test',
          filename: 'test-report.html',
        },
      ],
    ],
  }