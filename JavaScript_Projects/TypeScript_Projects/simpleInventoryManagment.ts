/**
  Ausgeführt auf der CodingLernplattform Coddy
**/


// Create the InventoryItem interface and the required objects
interface InventoryItem<T>{
    id: number,
    quantity: number,
    details: T,
}

let bookItem: InventoryItem<{title: string, author: string}> = {
    id: 1,
    quantity: 5,
    details: {title: "TypeScript Guide", author: "John Doe"}
}
let electronicItem: InventoryItem<{brand: string, model: string}> = {
    id: 2, 
    quantity: 3,
    details: {brand: "TechCorp", model: "X200"}

}
let clothingItem: InventoryItem<{size: string, color: string}> = {
    id: 3,
    quantity: 10,
    details: {size: "M", color: "Blue"}
}
//generic function adding new items to existing inventory
function addItem<T>(inventory: InventoryItem<T>[], newItem: InventoryItem<T>): InventoryItem<T>[]{
    return [...inventory, newItem]

}

let bookInventory = [bookItem]
let newBook: InventoryItem<{title: string, author: string}> = {
    id: 4,
    quantity:2,
    details: {title: "Advanced TypeScript" , author: "Jane Smith"}
}

let updateBookInventory = addItem(bookInventory, newBook)

let electronicInventory = [electronicItem]
let newElectronic: InventoryItem<{brand: string , model: string}> = {
    id: 5,
    quantity: 1,
    details:{brand: "GadgetCorp", model: "Z500"},

}

let updatedElectonicInventory = addItem(electronicInventory, newElectronic)

// generic func that search item by id
function findItemById<T>(inventory: InventoryItem<T>[], id: number): InventoryItem<T> | undefined{
    for(let i=0; i< inventory.length; i++){
        if(id === inventory[i].id){
            return inventory[i]
        }
    }
    return undefined
}

let mixedBookInventory: InventoryItem<{title: string, author: string}>[] = [
    {id:10, quantity: 3, details: {title: "JavaScript Basics", author: "Alice Brown"}}, 
    {id:11, quantity: 7, details: {title: "React Fundamentals", author:"Bob Wilson"}},
    {id:12, quantity: 2, details: {title: "Node.js Guide", author: "Carol Davis"}}
];

let mixedElectronicsInventory: InventoryItem<{brand: string , model: string}>[] = [
    {id: 20, quantity: 5, details: {brand: "Samsung", model: "Samsung Galaxy S23"}},
    {id: 21, quantity: 1, details: {brand: "Apple", model: "iPhone 15"}}
];

// 
type Book = {
    title: string,
    author: string,
}

type Electronic = {
    brand: string,
    model: string,
}

type BookItem = InventoryItem<Book>
type ElectronicItem = InventoryItem<Electronic>

let specificBook: BookItem = {
    id: 100,
    quantity: 8,
    details: {title: "Clean Code", author: "Robert Martin"},
}

let specificElectronic: ElectronicItem = {
    id: 200,
    quantity: 4,
    details: {brand: "Sony", model: "WH-1000XM4"}
}

let bookStore: BookItem[] = [specificBook]
let electronicStore: ElectronicItem[] = [specificElectronic]

let anotherBook: BookItem = {
    id:101,
    quantity: 3,
    details: {title: "Design Patterns", author:"Gang of Four"}
}

let expandedBookStore = addItem(bookStore, anotherBook)

//
function getItemDetails(item: InventoryItem<any>): void{
    if("title" in item.details){
        console.log(`Book: ${item.details.title} by ${item.details.author}`)
    }
    else if("brand" in item.details){
        console.log(`Electronic: ${item.details.brand} ${item.details.model}`)
    }
    else {console.log("Unknown item type")}
}

let testBook: InventoryItem<any> ={
    id: 300,
    quantity: 6,
    details: {title: "TypeScript Handbook", author: "Microsoft Team"}
}
let testElectronic: InventoryItem<any> = {
    id: 400, 
    quantity: 2,
    details: {brand: "Dell", model: "XPS 13"}
}
let unkownItem: InventoryItem<any> = {
    id:500,
    quantity: 1,
    details: {color: "Red", size: "Large"}
}

// Print the required outputs

// console.log(bookItem.id);
// console.log(bookItem.quantity);
// console.log(bookItem.details.title);
// console.log(bookItem.details.author);
// console.log(electronicItem.details.brand);
// console.log(electronicItem.details.model);
// console.log(clothingItem.details.size);
// console.log(clothingItem.details.color);

// console.log(updateBookInventory.length)
// console.log(updateBookInventory[1].details.title)
// console.log(updateBookInventory[1].details.author)
// console.log(updatedElectonicInventory.length)
// console.log(updatedElectonicInventory[1].details.brand)
// console.log(updatedElectonicInventory[1].details.model)
// console.log(updatedElectonicInventory[0].id)
// console.log(updatedElectonicInventory[1].quantity)

// console.log(findItemById(mixedBookInventory, 11)?.details.title)
// console.log(findItemById(mixedElectronicsInventory, 20)?.details.brand)
// console.log(findItemById(mixedBookInventory, 99))
// console.log(findItemById(mixedBookInventory,12)?.quantity)
// console.log(findItemById(mixedElectronicsInventory, 21)?.details.model)
// console.log(findItemById(mixedBookInventory, 10)?.id)
// console.log(findItemById(mixedElectronicsInventory, 50))

// console.log(specificBook.details.title)
// console.log(specificBook.details.author)
// console.log(specificElectronic.details.brand)
// console.log(specificElectronic.details.model)
// console.log(expandedBookStore.length)
// console.log(findItemById(expandedBookStore, 101)?.details.title)
// console.log(findItemById(electronicStore, 200)?.quantity)
// console.log(expandedBookStore[1].details.author)

getItemDetails(testBook)
getItemDetails(testElectronic)
getItemDetails(unkownItem)
let foundBookOne = findItemById(expandedBookStore,100)
getItemDetails(foundBookOne!)
let foundBookTwo = findItemById(electronicStore, 200)
getItemDetails(foundBookTwo!)


