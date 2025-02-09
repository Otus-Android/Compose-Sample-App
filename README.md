# Otus Jetpack Compose Sample App Project
This is a sample project for the Otus Online School "Android Developer. Professional" course, showcasing Jetpack Compose and modern Android development tools. It uses a public API to display Marvel characters.

## Tech Stack
- Jetpack Compose
- Hilt
- ViewModel
- Paging 3
- Navigation Component

## Structure
- Common **data** package: Shared logic for API, repositories, and models.
- Feature packages: Independent UI, ViewModel, and logic per feature.

## Get Api keys
This app utilizes the public Marvel API to retrieve Marvel-related data.
Obtaining Your API Keys
#### Step 1: Visit the Official Site (https://developer.marvel.com/documentation/generalinfo)
To obtain your API keys, navigate to the official Marvel API website:
Marvel API Documentation

#### Step 2: Register and Retrieve Keys
Sign up for an account and follow the instructions on the site to generate your: Public Key and  Private Key
Once you have obtained your keys, you need to configure your project to use them. This is done by adding the keys to the local.properties file in your project's root directory.

#### Step 3: Put keys in local.properties
Open (or create) the local.properties file and add your keys using the following format:
```
marvel.public.key=your_public_key_here
marvel.private.key=your_private_key_here
```
