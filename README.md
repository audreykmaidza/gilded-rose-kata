# gilded-rose-kata
# 🧪 Gilded Rose Kata – Inventory System Update

This project is a refactoring and feature-extension exercise based on the classic **Gilded Rose Kata**.  
The goal was to improve the structure and maintainability of the legacy inventory system, and to introduce support for a **new item type: Conjured items**.

---

## 🧾 Objective

- Take over the existing system written by another developer.
- Maintain all existing behavior and constraints.
- Introduce logic for **Conjured items**, which degrade in quality **twice as fast** as normal items.
- Ensure code follows clean architecture principles and is well-tested.

---

## 💼 Business Rules

Each item has two values:
- `sellIn`: days remaining to sell the item.
- `quality`: how valuable the item is.

Daily updates apply the following rules:

| Item Type | Behavior |
|-----------|----------|
| **Normal Items** | `quality` decreases by 1; once past sell date, by 2. |
| **Aged Brie** | `quality` increases as it ages (max 50). |
| **Backstage Passes** | `quality` increases:<br>+1 if `sellIn > 10`<br>+2 if `6 ≤ sellIn ≤ 10`<br>+3 if `0 ≤ sellIn ≤ 5`<br>→ drops to 0 after concert |
| **Sulfuras** | Legendary item; never sold, never changes in quality (fixed at 80). |
| **Conjured Items** | Degrade in `quality` **twice as fast**:<br>-2 before sell date, -4 after. |

> ⚠️ Constraints:
> - Quality is always ≥ 0 and ≤ 50 (except **Sulfuras**, always 80).
> - `sellIn` decreases daily for all items except **Sulfuras**.

---

## ✅ What Was Changed

- Reworked `update_quality` logic to be **cleaner, more testable, and easier to extend**.
- Implemented logic for:
  - `"Conjured"` items.
- Preserved the original `Item` class (as per constraints).
- Ensured **unit tests pass across all supported languages** (Python, Java, JavaScript).

---

## 🧪 How to Run Tests

### Python

```bash
cd python
python3 -m unittest discover
