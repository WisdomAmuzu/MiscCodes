__author__ = 'Amuzu Wisdodm'

def even(start, n):
    myList = []
    while len(myList) < n:
        if start % 2 == 0:
            myList.append(start)
        start += 1
    return myList


def movesCounter(numbers=[3, 4, 6, 6, 3]):
    movesRequired = 0
    for i in numbers:
        if i < 1 or i > 10*6:
            return 0
    if len(numbers) < 1 or len(numbers) > 10*5:
        return 0
        
    while True:
        largest = max(numbers)
        indexOf = numbers.index(largest)
        if numbers.count(largest) == len(numbers):
            return movesRequired
        for i in range(len(numbers)):
            if i !=  indexOf:
                numbers[i] = numbers[i] + 1
        movesRequired += 1
#       uncomment the code below to see the changes in the array as they occur
#        for i in numbers:
#            print(i, end=" ")
#        print("\n")
    return movesRequired        


def palindrom(n):
    n = str(n)
    nReversed = n[::-1]
    if n == nReversed:
        return 0
    else:
        return 1


def count(string, char):
    count = string.count(char)
    return count



def sumOfOddNums(arr):
    oddSum = sum([i for i in arr if i % 2 != 0])
    return oddSum


def numOp(x, y):
    if (x % 2) == 0:
        if (y % 2) == 0:
            return x + y
    return x * y

if __name__ == "__main__":
    print(palindrom(78535))
    print(count('Hello', 'l'))
    print(sumOfOddNums([2,6,2,9,3,3,7,1]))
    print(numOp(6,4))
    print(movesCounter())
