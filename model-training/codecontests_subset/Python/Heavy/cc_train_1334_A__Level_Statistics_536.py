from sys import stdin

def func(arr):
    a, b = arr[0][0], arr[0][1]
    if b > a:
        return 0
    for i in range(1, len(arr)):
        if (arr[i][0]-arr[i-1][0] < arr[i][1]-arr[i-1][1]) or (arr[i][0]-arr[i-1][0] < 0 or 0 > arr[i][1]-arr[i-1][1]):
            return 0
    return 1

for _ in range(int(stdin.readline())):
    n = int(stdin.readline())
    arr = []
    for i in range(n):
        p, c = map(int,stdin.readline().split())
        arr.append([p, c])
    if func(arr) == 1:
        print("YES")
    else:
        print("NO")
