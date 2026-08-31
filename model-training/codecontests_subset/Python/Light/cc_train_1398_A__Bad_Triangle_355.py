def solve(arr):
    ans = []
    s = arr[0]+arr[1]

    if s <= arr[-1]:
        print(1,2,len(arr))
    else:
        print(-1)

t = int(input())
for i in range(t):
    input()
    solve(list(map(int, input().split())))