from sys import stdin
from math import ceil, gcd

# Input data
#stdin = open("input", "r")


def func():

    return

for _ in range(int(stdin.readline())):
    n, m = map(int, stdin.readline().split())
    a = list(map(int, stdin.readline().split()))
    b = list(map(int, stdin.readline().split()))
    cond = False
    for i in range(n):
        if a[i] in b:
            cond = True
            break
    if cond == True:
        print("YES")
        print(1, a[i])
    else:
        print("NO")
