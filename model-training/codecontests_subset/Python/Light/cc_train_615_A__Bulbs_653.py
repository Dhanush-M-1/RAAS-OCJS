n, m = list(map(int, input().split()))
D = [list(map(int, input().split())) for x in range(n)]
C = []

for q in D:
    for p in range(1,len(q)):
        if q[p] not in C:
            C.append(q[p])

if len(C) == m:
    print('YES')
else:
    print("NO")