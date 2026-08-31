"""
https://codeforces.com/problemset/problem/519/B
"""

n = int(input())

a = [int(x) for x in input().split(" ")]
b = [int(x) for x in input().split(" ")]
c = [int(x) for x in input().split(" ")]

a.sort()
b.sort()
c.sort()

for i, n in enumerate(a):
    try:
        if a[i] != b[i]:
            print(n)
            break

    except IndexError:
        print(n)

for i, n in enumerate(b):
    try:
        if b[i] != c[i]:
            print(n)
            break
    
    except IndexError:
        print(n)