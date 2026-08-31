from collections import defaultdict

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

d = defaultdict(int)

for i in range(n):
    d[a[i]]+=1

for i in range(n - 1):
    d[b[i]] -= 1

f = 0
for i,j in d.items():
    if j>0:
        f = i
        print(i)
        break

e = defaultdict(int)
for i in range(n):
    e[a[i]] += 1

for i in range(n-2):
    e[c[i]] -= 1
e[f] -= 1

for i,j in e.items():
    if j>0:
        print(i)
        break
