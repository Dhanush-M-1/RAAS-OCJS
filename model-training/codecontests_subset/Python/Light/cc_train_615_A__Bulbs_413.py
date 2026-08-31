a, b = map(int, input().split())
c =[]
for i in range(a):
    k = list(map(int, input().split()))
    for j in range(1, len(k)):
        if k[j] not in c:
            c.append(k[j])
print('YES' if len(c) == b else 'NO')