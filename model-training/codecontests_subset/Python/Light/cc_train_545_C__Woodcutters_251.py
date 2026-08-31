n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))
cnt = 2
for i in range(1, n-1):
    x, h = arr[i]
    if x - h > arr[i-1][0]:
        cnt += 1
    elif x+h < arr[i+1][0]:
        cnt += 1
        arr[i][0] += h
print(cnt if n > 1 else 1)