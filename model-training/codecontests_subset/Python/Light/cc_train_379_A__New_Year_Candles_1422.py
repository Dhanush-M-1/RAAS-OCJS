import sys

def ii():
    return sys.stdin.readline().strip()

def idata():
    return [int(x) for x in ii().split()]

def solve_of_problem():
    a, b = idata()
    ans = 0
    while a >= b:
        c = a // b
        ans += b * c
        a -= (b - 1) * c
    print(ans + a)
    return

for ______ in range(1):
    solve_of_problem()