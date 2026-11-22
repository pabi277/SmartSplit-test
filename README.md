# SplitSmart — the app where YOU write the code

*A tiny Android app (Kotlin + Jetpack Compose — the same tech as CodeC). Everything is finished except the math. The math is yours.*

**Total project size: ~250 lines.** You can read every single file. Compare: CodeC is 95,000 lines.

---

## The deal

The app builds and runs **today** — but every answer shows `₹0.00`, because the 3 functions in **one file** are stubs:

```
app/src/main/java/com/pabi/splitsmart/Calculator.kt   ← THE ONLY FILE YOU TOUCH
```

Your job: make the math real. Push each attempt — **GitHub Actions runs the tests automatically and grades you**:

- 🟢 Green run = your functions are correct
- 🔴 Red run = open the run, read the red annotation, fix, push again

Mistakes cost nothing here. It's a separate repo. CodeC is safe forever.

---

## The 3 challenges (in `Calculator.kt`)

| # | Function | What it must do | What you'll learn |
|---|---|---|---|
| 1 | `tipAmount(bill, percent)` | `bill × percent ÷ 100` | Your first real function |
| 2 | `totalPerPerson(bill, percent, people)` | `(bill + tip) ÷ people`, treating 0 people as 1 | Reusing a function + edge cases |
| 3 | `roundUp(value)` (bonus) | Round up to the next whole rupee | Finding & using library functions |

Tests live in `app/src/test/java/com/pabi/splitsmart/CalculatorTest.kt` — they are the grader. Don't edit them (except once, on purpose, to see what "red" looks like!).

---

## Set it up on your phone (one time, ~15 min)

1. **Create a new empty repo** on github.com (phone browser): green **New** button → name it `SplitSmart` → Public → **don't** add README → Create.
2. **Import this project into CodeC**: Projects → **+** → *Import ZIP* → pick `SplitSmart.zip` (you download it from this chat).
3. **Connect it to GitHub** — pick whichever works with your app:
   - **Route A:** In CodeC, clone your empty `SplitSmart` repo into a second project, then copy the imported files into the cloned folder (long-press in the file tree), commit, push.
   - **Route B:** GitHub website → your repo → *Add file* → *Upload files* → upload the project files in batches.
4. Push → open **Actions** → watch the run → 🟢 → download the **SplitSmart-debug-apk** artifact → install.

Then do the 3 challenges, one push each. That's the whole plan.

---

## What each file is (the full map — yes, it's this small)

```
SplitSmart/
├── .github/workflows/build.yml   ← the cloud robot: builds APK + runs tests on every push
├── settings.gradle.kts           ← tells Gradle which modules exist (just :app)
├── build.gradle.kts              ← declares the plugins & versions
├── gradle.properties             ← build settings
└── app/
    ├── build.gradle.kts          ← the app's recipe: name, versions, libraries
    └── src/
        ├── main/
        │   ├── AndroidManifest.xml               ← declares the app to Android
        │   ├── java/com/pabi/splitsmart/
        │   │   ├── MainActivity.kt               ← the screen (DONE — read it, enjoy it)
        │   │   └── Calculator.kt                 ← 🎯 YOUR FILE (3 TODOs)
        │   └── res/                              ← name, theme, icon
        └── test/java/com/pabi/splitsmart/
            └── CalculatorTest.kt                 ← the grader (4 tests)
```

**Suggested reading order:** `CalculatorTest.kt` (see what's expected) → `Calculator.kt` (fill it) → `MainActivity.kt` (see how the UI calls your functions) → then the Gradle files when curious.
