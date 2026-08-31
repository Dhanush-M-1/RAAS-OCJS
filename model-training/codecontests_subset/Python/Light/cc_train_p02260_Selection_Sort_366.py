n = int(input())
arr = list(map(int, input().split()))

count = 0
for i in range(n):
    mini = i
    for j in range(i, n):
        if arr[j] < arr[mini]:
            mini = j
    if mini != i:
        arr[i], arr[mini] = arr[mini], arr[i]
        count += 1

print(*arr)
print(count)

