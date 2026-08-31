t = input()
t = int(t)

def solve(n, arr):

    a1 = arr[0]
    a2 = arr[1]

    for i in range(2, n):
        if a1+a2<=arr[i]:
            print(1, 2, i+1)
            return

    print(-1)
    return

for i in range(t):
    n = input()
    n = int(n)
    arr = list(map(int, input().split()))

    solve(n, arr)