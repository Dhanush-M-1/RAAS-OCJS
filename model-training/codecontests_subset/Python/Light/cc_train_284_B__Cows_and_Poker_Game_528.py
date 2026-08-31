from collections import Counter, defaultdict

BS="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
def to_base(s, b):
    res = ""
    while s:
        res+=BS[s%b]
        s//= b
    return res[::-1] or "0"
alpha = "abcdefghijklmnopqrstuvwxyz"
from math import floor, ceil,pi

tot = 0

n = int(input())
s = list(input())

c = Counter(s)

for i in s:
    if i=="F":
        continue
    else:
        c[i] -= 1
        if c["I"]==0:
            tot += 1
        c[i] += 1
print(tot)