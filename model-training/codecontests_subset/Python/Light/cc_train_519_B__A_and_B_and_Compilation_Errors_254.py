from collections import Counter

n = int(input())

x = [int(i) for i in input().split()]
y = [int(i) for i in input().split()]
z = [int(i) for i in input().split()]

X = Counter(x)
Y = Counter(y)
Z = Counter(z)

for a in x:
    if X[a] != Y[a]:
        print(a)
        break

for a in y:
    if Y[a] != Z[a]:
        print(a)
        break