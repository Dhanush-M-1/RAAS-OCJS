n = int(input())
a = list(map(int, input().split()))
count = 0

for i in range(n-1):
    min_j = i
    for j in range(i+1, n):
        if a[j] < a[min_j]:
            min_j = j
    if min_j != i:
        a[i], a[min_j] = a[min_j], a[i]
        count += 1

print(*a)
print(count)
