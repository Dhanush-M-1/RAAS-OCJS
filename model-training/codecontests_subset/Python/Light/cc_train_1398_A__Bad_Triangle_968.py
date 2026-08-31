def solve(N, arr):
    arr.sort()
    if arr[0] + arr[1] > arr[N - 1] and arr[0] + arr[N - 1] > arr[1] and arr[N - 1] + arr[0] > arr[0]:
        print(-1)
    else:
        print(1, 2, N)


t = int(input())
while t != 0:
    n = int(input())
    a = list(map(int, input().split(' ')))
    solve(n, a)
    t -= 1
