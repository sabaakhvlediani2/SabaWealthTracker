# WealthTracker SA

## Student Information
- **Student:** საბა ახვლედიანი (Saba Akhvlediani)

## K Coefficient Calculation
- Position of ს (first letter of name) in Georgian alphabet: 4
- Position of ა (first letter of surname) in Georgian alphabet: 10
- Total letters in surname "ახვლედიანი": 22 (used as divisor)
- **K = (4 + 10) / 22 = 14.0 / 22.0 = 0.6364**

## Final Savings Formula
```
Final Savings = (Income - Expenses) * K
```
Where K = 0.6364

## ViewPager2 Orientation
- Surname "ახვლედიანი" starts with the letter **ა**
- Georgian vowels: ა, ე, ი, ო, უ
- Since ა is a vowel, ViewPager2 orientation is set to **HORIZONTAL**

## Naming Convention
- All resource IDs use the prefix **sa_ni_**
- **sa** = initials ს.ა. (საბა ახვლედიანი)
- **ni** = last 2 letters of ახვლედიანი (ნი)

## Architecture
- Single Activity (MainActivity) with ViewPager2 + TabLayout
- 3 Fragments: InputFragment, AnalyticsFragment, ProfileFragment
- Data passing: Fragment Result API
- Business logic: WealthManager.kt

## Tech Stack
- Kotlin, Min SDK 24, Target SDK 34
- AndroidX, Material Components, ConstraintLayout, ViewPager2
