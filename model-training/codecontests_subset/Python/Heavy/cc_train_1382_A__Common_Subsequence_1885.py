# Author: SaykaT
# Problem: 1382A
# Time Created: July 24(Friday) 2020 || 11:07:36

#>-------------------------<#

# Helper Functions. -> Don't cluster your code.

# IO Functions. -> Input output
def io():
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    if n > m:
        c = a.copy()
        d = b.copy()
    else:
        c = b.copy()
        d = a.copy()

    return [n, m, c, d]

# Main functions. -> Write the main solution here
def solve():
    n, m, a, b = io()
    ans = 'NO'

    for i in range(len(b)):
        for j in range(len(a)):
            if b[i] == a[j]:
                ans = 'YES'
                print(ans)
                print(1, b[i])
                break
            if ans == 'YES':
                break
        if ans == 'YES':
            break

    if ans != 'YES':
        print('NO')

    

# Multiple test cases. -> When you have T test cases.
T = int(input()) 
for _ in range(T):
    solve()
