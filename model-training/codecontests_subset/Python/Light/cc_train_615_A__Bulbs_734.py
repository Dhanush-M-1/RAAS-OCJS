n, m = map(int, input().split())
mass = [0]*m
sum = 0

for i in range(n):
    a = [int(s) for s in input().split()]
    for j in range(1, len(a)):
        if mass[a[j] - 1] == 0:
            mass[a[j] - 1] = 1
            sum += 1
    if sum == m:
        break

if sum == m:
    print('YES')
else:
    print('NO')
