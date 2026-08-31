# Author: SaykaT
# Problem: 385A
# Time Created: September 27(Sunday) 2020 || 11:03:31

#>-------------------------<#

#>-------------------------<#


# Helper Functions. -> Don't cluster your code.


# Main functions. -> Write the main solution here
def solve():
    n, c = map(int, input().split())
    ls = list(map(int, input().split()))
    price = []

    for i in range(len(ls)-1):
        price.append(ls[i] - ls[i+1])

    profit = (max(price) - c)
    if profit > 0:
        print(profit)
    else:
        print(0)

# Single test cases
solve()

