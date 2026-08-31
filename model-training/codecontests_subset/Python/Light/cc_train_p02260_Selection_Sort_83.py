n = int(input())
a = list(map(int, input().split()))
cnt = 0
for i in range(n - 1):
    minj = i
    for j in range(i, n):
        if a[j] < a[minj]:
            minj = j
    if minj != i:
        a[i], a[minj] = a[minj], a[i]
        cnt += 1
print(" ".join(map(str, a)))
print(cnt)
