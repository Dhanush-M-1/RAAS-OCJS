# main.py
 
# Code Jam only
# import numpy as np
# import scipy as sp
 
import sys

# import itertools
# import functools

# import math

input = sys.stdin.readline

mod = pow(10, 9) + 7
 
arr = [0]*(200020)
for i in range(10):
    arr[i] = 1
for i in range(10, 200020):
    arr[i] = (arr[i-10] + arr[i-9])%mod


def solve():
    n, m = map(int, input().split(' '))
    ans = 0
    while True:
        k = m + n%10
        ans += arr[k]
        n = n//10
        if n == 0:
            break
    print(ans%mod)
 
 
if __name__ == "__main__":
    for t in range(int(input())):
        # print(f"Case #{t+1}: {solve()}")
        solve()