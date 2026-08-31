# Author: SaykaT
# Problem: 433A
# Time Created: August 02(Sunday) 2020 || 04:41:30

#>-------------------------<#
import sys

input = sys.stdin.readline
#>-------------------------<#


# Helper Functions. -> Don't cluster your code.


# IO Functions. -> Input output
def io():
    n = int(input())
    ls = sorted(list(map(int, input().split())), reverse=True)

    return n, ls


# Main functions. -> Write the main solution here
def solve():
    n, ls = io()
    a = 0
    b = 0
    for i in ls:
        if a > b:
            b += i
        else:
            a += i
    if a == b:
        print('YES')
    else:
        print('NO')


# Multiple test cases. -> When you have T test cases.
solve()

