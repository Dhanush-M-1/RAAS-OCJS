n = int(input())
a = list(map(int, input().split()))

count = 0
for i in range(n):
    minj = i
    for j in range(i,n,1):
        if a[minj] > a[j]:
            minj = j
    if minj != i:
        a[minj], a[i] = a[i], a[minj]
        count += 1
print(*a)
print(count)

