N = int(input())
ad = {}
bd = {}
cd = {}

A = list(map(int, input().split()))
for a in A:
    ad[a] = ad.get(a, 0) + 1

B = list(map(int, input().split()))
for b in B:
    bd[b] = bd.get(b, 0) + 1

C = list(map(int, input().split()))
for c in C:
    cd[c] = cd.get(c, 0) + 1

for a in ad.keys():
    if a not in bd or ad[a] != bd[a]:
        print(a)

for b in bd.keys():
    if b not in cd or bd[b] != cd[b]:
        print(b)
