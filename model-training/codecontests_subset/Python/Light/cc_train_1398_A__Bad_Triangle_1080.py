def solve(n,ar):


    if ar[n-1] >= ar[0]+ar[1]:
        print(1, 2, n)
    else:
        print(-1)


if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        ar = list(map(int,input().split()))

        solve(n,ar)