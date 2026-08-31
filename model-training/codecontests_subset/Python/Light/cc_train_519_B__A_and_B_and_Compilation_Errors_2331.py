from collections import Counter

N = int(input())

A = [int(i) for i in input().split()]
B = [int(i) for i in input().split()]
C = [int(i) for i in input().split()]

ca = Counter(A)
cb = Counter(B)
cc = Counter(C)

for b in B:
    ca[b] -= 1

for error, c in ca.items():
    if c > 0:
        print(error)
        break

for c in C:
    cb[c] -= 1

for error, c in cb.items():
    if c > 0:
        print(error)
        break
