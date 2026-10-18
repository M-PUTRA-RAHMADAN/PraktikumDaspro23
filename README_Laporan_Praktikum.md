# JOBSHEET - BASIC PROGRAMMING: SELECTION STATEMENTS

**Student Identity**
- **Name:** [Fill in your name]
- **Student ID (NIM):** [Fill in your NIM]
- **Class / Attendance No.:** [Fill in your class and number]

## Project Structure

```text
.
├── README_Laporan_Praktikum.md
├── Senja_CoffeeShop_BasicSelection.java  (Experiment 1)
├── StudiKasus2.java                      (Experiment 2 / Case Study)
└── output-evidence/                      (add screenshots from your own program runs, if required)
```

---

## 1. PRACTICUM OBJECTIVES

The objectives of this practicum are:

1. To understand how `if`, `if-else`, and nested `if` statements control program flow.
2. To apply selection statements to solve practical problems involving discounts, payments, and eligibility checks.
3. To use comparison and logical operators to evaluate conditions.
4. To test programs using different inputs and compare the actual output with the expected result.
5. To identify limitations in a program and suggest improvements to make its output clearer and more reliable.

---

## 2. EXPERIMENT RESULTS & ANALYSIS

### 2.1 Experiment 1: Senja Coffee Shop Checkout and Discount

#### 2.1.1 Problem Description

Senja Coffee Shop sells each cup of coffee for **Rp18,000**. The program asks the customer to enter the number of cups and the amount of money paid. If the total price is **Rp100,000 or more**, the customer receives a **10% discount**. The program then calculates the final payment and checks whether the money paid is enough. If the payment is sufficient, the program displays the change; otherwise, it displays the remaining shortfall.

#### 2.1.2 Java Program Code

```java
import java.util.Scanner;

public class Senja_CoffeeShop_BasicSelection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        // Declaration of variables
        int priceperCup = 18000;
        int total_price;
        double change;
        double discount;
        double shortfall; // added to match the "kurang" variable in the flowchart
        
        // Input data 
        System.out.print("How many cups you want to buy: ");
        int totalcups = sc.nextInt();

        System.out.print("Input your payment: ");
        double payment = sc.nextDouble();
 
        double total_payment;

        // Calculation
        total_price = totalcups * priceperCup;
        discount = 0;
        
        // Selection using if-else to determine discount
        if (total_price >= 100000) {
            discount = total_price * 10 / 100;
        } else {
            discount = 0;
        }
        
        total_payment = total_price - discount;
          
        // Output data from calculation discount and total payment
        System.out.println("Total Price: " + total_price);  
        System.out.println("Discount: " + discount);
        System.out.println("Total Payment: " + total_payment);
        
        // if-else selection to determine change or shortfall
        if (payment >= total_payment) {
            change = payment - total_payment;
            System.out.println("Change: " + change);
        } else {
            shortfall = total_payment - payment;
            System.out.println("Not enough money, shortfall Rp: " + shortfall);
        }
        
        sc.close();
    }
}
```

#### 2.1.3 Sample Console Output

Example input: 6 cups, payment Rp100,000.

```text
How many cups you want to buy: 6
Input your payment: 100000
Total Price: 108000
Discount: 10800.0
Total Payment: 97200.0
Change: 2800.0
```

*The block above is a text representation of a sample run, not a screenshot. If the lecturer requires screenshots, run the program in your IDE and add your own console screenshot to `output-evidence/`.*

#### 2.1.4 Test Table

| No. | Cups | Payment (Rp) | Total Price (Rp) | Discount (Rp) | Final Payment (Rp) | Expected Result |
|:---:|---:|---:|---:|---:|---:|---|
| 1 | 6 | 100,000 | 108,000 | 10,800 | 97,200 | Change: Rp2,800 |
| 2 | 5 | 90,000 | 90,000 | 0 | 90,000 | Change: Rp0 |
| 3 | 6 | 90,000 | 108,000 | 10,800 | 97,200 | Shortfall: Rp7,200 |
| 4 | 4 | 75,000 | 72,000 | 0 | 72,000 | Change: Rp3,000 |
| 5 | 7 | 100,000 | 126,000 | 12,600 | 113,400 | Shortfall: Rp13,400 |

#### 2.1.5 Answers to Questions

**Question 1: Why does buying six cups qualify for a discount, while buying five cups does not?**  
**Answer:** Six cups cost 6 × Rp18,000 = Rp108,000, which meets the Rp100,000 threshold. Five cups cost 5 × Rp18,000 = Rp90,000, which is below the threshold. Therefore, only the six-cup purchase receives the 10% discount.

**Question 2: How does the program calculate the final payment?**  
**Answer:** It first calculates `total_price` by multiplying the number of cups by Rp18,000. If the total is at least Rp100,000, the discount is 10% of the total. The final payment is calculated by subtracting the discount from the total price.

**Question 3: What happens when the customer pays less than the final payment?**  
**Answer:** The condition `payment >= total_payment` is false. The program calculates `shortfall = total_payment - payment` and displays the amount of money still needed.

**Question 4: What is the purpose of the `if-else` statement used for the discount?**  
**Answer:** It selects one of two outcomes. When `total_price >= 100000` is true, the program calculates a 10% discount. Otherwise, the discount remains zero.

**Question 5: What validation should be added to make this program safer to use?**  
**Answer:** The program should check that the number of cups is greater than zero and that the payment is not negative. Without these checks, a user could enter an unrealistic quantity or payment value.

#### 2.1.6 Analysis

This experiment demonstrates a basic `if-else` selection. The first decision determines whether the purchase qualifies for a discount. A second decision compares the payment with the final amount due. The calculations are performed before the corresponding output is displayed. The test cases cover purchases both below and above the discount threshold, as well as sufficient and insufficient payments.

---

### 2.2 Experiment 2: Student Activity Award Eligibility (Nested Selection)

#### 2.2.1 Problem Description

This program determines whether a student qualifies for an activity award. The required checks depend on the activity category:

1. For **BELMAWA**, **BAKORMA**, or **MANDIRI**, the student must obtain a competition rank from 1 to 3 and submit exactly four documents.
2. For **PKM**, the proposal must be funded (`1`) and the student must submit exactly four documents.
3. **LAINNYA** is outside the eligible activity categories.
4. Any category name that does not match the supported options is treated as invalid.

#### 2.2.2 Java Program Code

```java
import java.util.Scanner;

public class StudiKasus2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input Name and Activity Type
        System.out.print("Nama mahasiswa : ");
        String nama = sc.nextLine();
        
        System.out.print("Jenis kegiatan (BELMAWA/BAKORMA/MANDIRI/PKM/LAINNYA) : ");
        String jenisKegiatan = sc.nextLine();

        // Level 1: Check Activity Type
        if (jenisKegiatan.equalsIgnoreCase("BELMAWA") || 
            jenisKegiatan.equalsIgnoreCase("BAKORMA") || 
            jenisKegiatan.equalsIgnoreCase("MANDIRI")) {
            
            System.out.print("Jumlah dokumen : ");
            int jumlahDokumen = sc.nextInt();
            
            System.out.print("Peringkat juara : ");
            int peringkat = sc.nextInt();

            // Level 2: Check Competition Rank
            if (peringkat >= 1 && peringkat <= 3) {
                // Level 3: Check Document Completeness
                if (jumlahDokumen == 4) {
                    System.out.println("Status : Dokumen lengkap. Dana penghargaan diberikan.");
                } else {
                    int kurang = 4 - jumlahDokumen;
                    System.out.println("Status : Dokumen tidak lengkap (kurang " + kurang + " dokumen). Dana penghargaan tidak diberikan.");
                }
            } else {
                System.out.println("Status : Bukan juara 1, 2, atau 3. Dana penghargaan tidak diberikan.");
            }

        } else if (jenisKegiatan.equalsIgnoreCase("PKM")) {
            
            System.out.print("Jumlah dokumen : ");
            int jumlahDokumen = sc.nextInt();
            
            System.out.print("Status didanai (1=disetujui, 0=tidak) : ");
            int statusDidanai = sc.nextInt();

            // Level 2: Check PKM Funding Status
            if (statusDidanai == 1) {
                // Level 3: Check Document Completeness
                if (jumlahDokumen == 4) {
                    System.out.println("Status : Dokumen lengkap. Dana penghargaan diberikan.");
                } else {
                    int kurang = 4 - jumlahDokumen;
                    System.out.println("Status : Dokumen tidak lengkap (kurang " + kurang + " dokumen). Dana penghargaan tidak diberikan.");
                }
            } else {
                System.out.println("Status : Proposal tidak didanai. Dana penghargaan tidak diberikan.");
            }

        } else if (jenisKegiatan.equalsIgnoreCase("LAINNYA")) {
            // No additional data needed for 'Lainnya'
            System.out.println("Status : Jenis kegiatan tidak termasuk kategori penerima dana penghargaan.");
        } else {
            System.out.println("Status : Jenis kegiatan tidak valid.");
        }

        sc.close();
    }
}
```

#### 2.2.3 Sample Console Output

**Example A — eligible student:**

```text
Nama mahasiswa : Andi Pratama
Jenis kegiatan (BELMAWA/BAKORMA/MANDIRI/PKM/LAINNYA) : BELMAWA
Jumlah dokumen : 4
Peringkat juara : 1
Status : Dokumen lengkap. Dana penghargaan diberikan.
```

**Example B — PKM proposal not funded:**

```text
Nama mahasiswa : Nabila Putri
Jenis kegiatan (BELMAWA/BAKORMA/MANDIRI/PKM/LAINNYA) : PKM
Jumlah dokumen : 4
Status didanai (1=disetujui, 0=tidak) : 0
Status : Proposal tidak didanai. Dana penghargaan tidak diberikan.
```

*These are text representations of sample runs, not screenshots. Add screenshots from your own execution if required by the assignment.*

#### 2.2.4 Test Table

| No. | Activity | Documents | Rank / Funding Status | Expected Result |
|:---:|---|---:|---|---|
| 1 | BELMAWA | 4 | Rank 1 | Documents complete; award granted |
| 2 | BAKORMA | 3 | Rank 2 | Incomplete; 1 document missing |
| 3 | MANDIRI | 4 | Rank 4 | Not ranked 1, 2, or 3; no award |
| 4 | PKM | 4 | Funded (`1`) | Documents complete; award granted |
| 5 | PKM | 2 | Funded (`1`) | Incomplete; 2 documents missing |
| 6 | PKM | 4 | Not funded (`0`) | Proposal not funded; no award |
| 7 | LAINNYA | Not requested | Not requested | Category is not eligible |
| 8 | INVALID | Not requested | Not requested | Invalid activity type |

#### 2.2.5 Answers to Questions

**Question 1: Why does the program check the activity category before requesting other information?**  
**Answer:** The information needed depends on the category. Competition activities require a rank, while PKM requires a funding status. The first selection determines which additional inputs and conditions must be checked.

**Question 2: Why does the competition rank condition use `peringkat >= 1 && peringkat <= 3`?**  
**Answer:** The `&&` operator requires both comparisons to be true. This condition accepts only ranks 1, 2, and 3; ranks below 1 or above 3 are rejected.

**Question 3: How are BELMAWA/BAKORMA/MANDIRI different from PKM in this program?**  
**Answer:** The first three categories are evaluated using the competition rank. PKM is evaluated using the proposal funding status. Both paths then check whether the required number of documents has been submitted.

**Question 4: What is the purpose of `equalsIgnoreCase()`?**  
**Answer:** It compares text without distinguishing uppercase and lowercase letters. For example, `pkm`, `PKM`, and `Pkm` are treated as the same category.

**Question 5: What issue can occur if the user enters more than four documents?**  
**Answer:** In the supplied program, the document condition checks `jumlahDokumen == 4`. If the entered quantity is greater than four, it enters the `else` branch and calculates `4 - jumlahDokumen`, producing a negative number that is incorrectly described as documents missing. The program should handle this case separately or revise the rule after confirming whether four documents are required exactly or at least four are required.

#### 2.2.6 Analysis

This experiment uses nested selection because a student reaches later checks only after passing the earlier condition. The activity category determines the path, and the rank or funding status is evaluated before document completeness. This structure makes the eligibility criteria explicit and avoids asking for irrelevant information. The program should be improved by validating negative document counts, handling quantities above four, and checking that the funding status is either `0` or `1`.

---

## 3. ADDITIONAL TESTING AND EVALUATION

The test cases show that both programs follow their stated selection rules for normal inputs. The coffee shop program distinguishes purchases above and below the discount threshold and handles both overpayment and underpayment. The student award program uses different decision paths for competition activities and PKM.

The following boundary conditions deserve attention:

- **Coffee shop:** reject zero or negative cup quantities and negative payment values.
- **Award eligibility:** reject negative document quantities and handle quantities above four without displaying a negative number of missing documents.
- **Award eligibility:** validate funding status so that only `0` and `1` are accepted.
- **Both programs:** test invalid input types and unexpected text where practical.

---

## 4. CONCLUSION

This practicum demonstrates how selection statements solve practical decision-making problems in Java. The Senja Coffee Shop program uses `if-else` to calculate a discount and determine whether the customer receives change or still owes money. The student award program uses nested selection to evaluate activity categories, competition ranks or funding status, and document completeness. Testing with multiple input combinations helps confirm expected behavior and reveal possible edge-case errors. Clear conditions, valid input checks, and meaningful messages are important for making programs more reliable and easier to understand.
