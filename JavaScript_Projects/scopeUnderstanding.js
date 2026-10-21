export class BankAccount {
    
  #balance;
 
  constructor(accountHolder, initialBalance = 0) {
    this.accountHolder = accountHolder;
    this.#balance = initialBalance;
  }
  
  getBalance() {
    return this.#balance;
  }
  
  getAccountInfo() {
    return `${this.accountHolder}: $${this.#balance}`;
  }
  
  deposit(amount) {
    if (amount > 0) {
      this.#balance += amount;
      console.log(`Deposited $${amount}`);
    } else {
      console.log(`Invalid deposit amount`);
    }
  }
  
  withdraw(amount) {
    if (amount > 0 && amount <= this.#balance) {
      this.#balance -= amount;
      console.log(`Withdrew $${amount}`);
    } else {
      console.log(`Invalid withdrawal amount or insufficient funds`);
    }
  }
}
