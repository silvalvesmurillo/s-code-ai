# HTTP Cat Android App - UI Mockup

## Main Screen

```
┌─────────────────────────────────────────────────────────┐
│  ☰  HTTP Cat                                        ⋮   │ <- TopAppBar (Material 3)
├─────────────────────────────────────────────────────────┤
│                                                         │
│  ┌───────────────────────────────────────────────────┐ │
│  │  HTTP 100                                         │ │
│  │  ┌───────────────────────────────────────────────┤ │
│  │  │                                               │ │
│  │  │           [Cat Image for 100]                │ │
│  │  │         (Continue/Processing)                │ │
│  │  │                                               │ │
│  │  └───────────────────────────────────────────────┤ │
│  │  https://http.cat/100                            │ │
│  └───────────────────────────────────────────────────┘ │ <- Card in LazyColumn
│                                                         │
│  ┌───────────────────────────────────────────────────┐ │
│  │  HTTP 200                                         │ │
│  │  ┌───────────────────────────────────────────────┤ │
│  │  │                                               │ │
│  │  │            [Cat Image for 200]               │ │
│  │  │            (OK/Success)                      │ │
│  │  │                                               │ │
│  │  └───────────────────────────────────────────────┤ │
│  │  https://http.cat/200                            │ │
│  └───────────────────────────────────────────────────┘ │
│                                                         │
│  ┌───────────────────────────────────────────────────┐ │
│  │  HTTP 404                                         │ │
│  │  ┌───────────────────────────────────────────────┤ │
│  │  │                                               │ │
│  │  │            [Cat Image for 404]               │ │
│  │  │          (Not Found/Error)                   │ │
│  │  │                                               │ │
│  │  └───────────────────────────────────────────────┤ │
│  │  https://http.cat/404                            │ │
│  └───────────────────────────────────────────────────┘ │
│                                                         │
│  ┌───────────────────────────────────────────────────┐ │
│  │  HTTP 500                                         │ │
│  │  ┌───────────────────────────────────────────────┤ │
│  │  │                                               │ │
│  │  │            [Cat Image for 500]               │ │
│  │  │       (Internal Server Error)                │ │
│  │  │                                               │ │
│  │  └───────────────────────────────────────────────┤ │
│  │  https://http.cat/500                            │ │
│  └───────────────────────────────────────────────────┘ │
│                                                         │
│  ... (scroll for more items) ...                       │
│                                                         │
└─────────────────────────────────────────────────────────┘
     ▲ Swipe up to see more HTTP status codes ▲
```

## Loading State

```
┌─────────────────────────────────────────────────────────┐
│  ☰  HTTP Cat                                        ⋮   │
├─────────────────────────────────────────────────────────┤
│                                                         │
│                                                         │
│                                                         │
│                      ◉                                  │ <- CircularProgressIndicator
│                                                         │
│           Loading HTTP Cat images...                    │
│                                                         │
│                                                         │
│                                                         │
│                                                         │
└─────────────────────────────────────────────────────────┘
```

## Error State

```
┌─────────────────────────────────────────────────────────┐
│  ☰  HTTP Cat                                        ⋮   │
├─────────────────────────────────────────────────────────┤
│                                                         │
│                                                         │
│                                                         │
│                      ⚠️                                  │
│                                                         │
│         Failed to load HTTP cat images                  │
│         Please check your connection                    │
│                                                         │
│              ┌─────────────────┐                        │
│              │     RETRY       │                        │ <- Button
│              └─────────────────┘                        │
│                                                         │
└─────────────────────────────────────────────────────────┘
```

## Features

### LazyColumn
- **Efficient scrolling**: Only renders visible items
- **Smooth animations**: Material motion design
- **Padding**: 16dp around edges and between items

### Card Design (Material 3)
- **Elevation**: 4dp shadow for depth
- **Rounded corners**: Modern look
- **Content padding**: 16dp internal spacing
- **Typography**: 
  - Title: Large, primary color
  - URL: Small, secondary color

### Image Loading (Coil)
- **Async loading**: Non-blocking UI
- **Placeholder**: Shows while loading
- **Error handling**: Fallback for failed loads
- **Caching**: Automatic image caching
- **ContentScale.Fit**: Images maintain aspect ratio

### State Management
- **Loading**: CircularProgressIndicator with text
- **Success**: LazyColumn with all items
- **Error**: Error message with retry button
- **Empty**: Message when no data available

### Responsive Layout
- **Flexible height**: Images between 200dp-400dp
- **Full width**: Cards span screen width
- **Scroll**: Natural vertical scrolling
- **Touch targets**: Material guidelines (48dp minimum)

### Material Design 3
- **Color scheme**: System-generated palette
- **Typography**: Material 3 type scale
- **Components**: Latest Material Design
- **Accessibility**: Support for large text, contrast

## Code Structure

```kotlin
MainActivity
    └── HttpCatTheme
        └── Scaffold
            ├── TopAppBar (title="HTTP Cat")
            └── HttpCatScreen
                ├── LoadingScreen (when isLoading)
                ├── ErrorScreen (when error != null)
                ├── EmptyScreen (when statuses.isEmpty())
                └── HttpCatList (success state)
                    └── LazyColumn
                        └── items(statuses)
                            └── HttpCatItem (Card)
                                ├── Text (status code)
                                ├── AsyncImage (cat image)
                                └── Text (URL)
```

## Permissions

The app requires internet permissions to fetch images from http.cat:

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

## Performance

- **Efficient**: LazyColumn only renders visible items
- **Cached**: Coil caches images automatically
- **Smooth**: 60fps scrolling with Compose
- **Memory**: Efficient image loading and recycling

## User Experience

1. App launches → Shows loading screen
2. Data loads → Transitions to list
3. User scrolls → Smooth LazyColumn navigation
4. Images load → Progressive display with Coil
5. Error occurs → Clear message with retry option
