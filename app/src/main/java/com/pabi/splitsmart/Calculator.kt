package com.pabi.splitsmart

/*
 * ════════════════════════════════════════════════════════════════
 *   THIS IS THE ONLY FILE YOU NEED TO EDIT. This is YOUR file.
 *
 *   Right now the app runs but shows ₹0.00 everywhere, because all
 *   three functions return a placeholder. Your job: make the math
 *   real — one TODO at a time.
 *
 *   How you'll know you're right:
 *     push → GitHub Actions runs CalculatorTest.kt → 🟢 green
 *     wrong answer → 🔴 red, with a message naming the test.
 * ════════════════════════════════════════════════════════════════
 */

object Calculator {

    // ── TODO 1 ─────────────────────────────────────────────────
    // Return the tip money: billAmount × tipPercent ÷ 100.
    //
    // Example: tipAmount(500.0, 10) must be 50.0
    //
    // (Delete the `return 0.0` line and write your own.)
    fun tipAmount(billAmount: Double, tipPercent: Int): Double {
        return 0.0 // ← replace me
    }

    // ── TODO 2 ─────────────────────────────────────────────────
    // Return what EACH person pays: (bill + tip) ÷ people.
    //
    // Reuse your TODO 1 work — you can call your own function:
    //     tipAmount(billAmount, tipPercent)
    //
    // Edge case: if `people` is 0 (or negative), treat it as 1 person.
    // Hint: kotlin.math.max(1, people) gives the bigger of the two.
    fun totalPerPerson(billAmount: Double, tipPercent: Int, people: Int): Double {
        return 0.0 // ← replace me
    }

    // ── TODO 3 (bonus) ─────────────────────────────────────────
    // Return the value rounded UP to the next whole rupee.
    //
    // Example: roundUp(110.2) must be 111.0 (and roundUp(111.0) is 111.0)
    //
    // Hint: kotlin.math.ceil does exactly this. Import it at the top
    // of the file: import kotlin.math.ceil
    fun roundUp(value: Double): Double {
        return value // ← replace me
    }
}
