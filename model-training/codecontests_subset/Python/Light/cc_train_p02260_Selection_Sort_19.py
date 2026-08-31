n = int(input())
a = list(map(int, input().split()))
cnt = 0
for i in range(n):
    minv = i
    for j in range(i, n):
        if a[j] < a[minv]:
            minv = j
    if minv != i:
        a[i], a[minv] = a[minv], a[i]
        cnt += 1

print(*a)
print(cnt)

