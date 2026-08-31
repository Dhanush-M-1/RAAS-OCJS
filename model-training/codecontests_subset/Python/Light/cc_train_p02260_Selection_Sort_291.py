n = int(input())
arr = list(map(int, input().split()))
cnt = 0
for i in range(len(arr)):
    Min = i
    for j in range(i, len(arr)):
        if arr[j] < arr[Min]:
            Min = j
    if i != Min:
        arr[i], arr[Min] = arr[Min], arr[i]
        cnt += 1
print(*arr)
print(cnt)
