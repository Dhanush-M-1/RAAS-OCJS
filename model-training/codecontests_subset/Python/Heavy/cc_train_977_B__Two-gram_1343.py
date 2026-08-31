# Author: S Mahesh Raju
# Username: maheshraju2020
# Date: 30/06/2020

from sys import stdin,stdout
from math import gcd, ceil, sqrt
ii1 = lambda: int(stdin.readline().strip())
is1 = lambda: stdin.readline().strip()
iia = lambda: list(map(int, stdin.readline().strip().split()))
isa = lambda: stdin.readline().strip().split()
mod = 1000000007

def occurrences(string, sub):
    count = start = 0
    while True:
        start = string.find(sub, start) + 1
        if start > 0:
            count += 1
        else:
            return count

n = ii1()
s = is1()
search = set()
for i in range(1, len(s)):
    search.add(s[i - 1 : i + 1])
res = []
for i in search:
    res.append([occurrences(s, i), i])
res.sort(reverse=True)
print(res[0][1])