def solve(n, arr):
    val = arr[0] + arr[1]
    for i in range(2, n):

        if val <= arr[i]:
            print(1, 2, i+1)
            return
    for j in range(n-2):
        if arr[j] + arr[j+1] <= arr[j+2]:
            print(j+1, j+2, j+3)
            return
        else:
            continue
    print(-1)



for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split(' ')))
    (solve(n, arr))
