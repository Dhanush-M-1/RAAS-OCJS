import math

for _ in range(int(input())):
    n = int(input())
    arr = [int(i) for i in input().split()]
    mean = []
    visited = [0] * n
    for i in range(n):
        if arr[i] == -1:
            if i == 0 or i == n - 1:
                if i == 0:
                    if arr[i + 1] >= 0 and visited[i + 1] == 0:
                        mean.append(arr[i + 1])
                        visited[i + 1] = 1
                else:
                    if arr[i - 1] >= 0 and visited[i - 1] == 0:
                        mean.append(arr[i - 1])
                        visited[i - 1] = 1
            else:
                if arr[i + 1] >= 0 and visited[i + 1] == 0:
                    mean.append(arr[i + 1])
                    visited[i + 1] = 1
                if arr[i - 1] >= 0 and visited[i - 1] == 0:
                    mean.append(arr[i - 1])
                    visited[i - 1] = 1
    max_diff = 0
    # print(mean)
    for i in range(n - 1):
        if arr[i] >= 0 and arr[i + 1] >= 0:
            max_diff = max(max_diff, abs(arr[i] - arr[i + 1]))
    if len(mean) == 0:
        print(max_diff, 0)
    else:
        km = (max(mean)+min(mean)) // 2
        t1 = 0
        for i in range(n):
            if arr[i] == -1:
                arr[i] = km
        for i in range(n-1):
            t1 = max(t1, abs(arr[i] - arr[i+1]))
        print(t1, km)
