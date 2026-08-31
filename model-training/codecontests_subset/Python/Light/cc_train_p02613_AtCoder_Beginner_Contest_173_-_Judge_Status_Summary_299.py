import collections
n=int(input())
s=[input() for _ in range(n)]
c=collections.Counter(s)
for i in ["AC","WA","TLE","RE"]:
    print(f"{i} x {c[i]}")