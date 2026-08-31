import math
from collections import deque
from sys import stdin, stdout
from string import ascii_letters
input = stdin.readline
#print = stdout.write
letters = ascii_letters[:26]
 
for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    first = arr[0]
    second = arr[-1]
    can = False
    res = 0
    for i in range(1, n - 1):
        if arr[i] + first <= second or arr[i] + second <= first:
            can = True
            res = i
            break
    if can:
        print(*[1, res + 1, n])
    else:
        print(-1)