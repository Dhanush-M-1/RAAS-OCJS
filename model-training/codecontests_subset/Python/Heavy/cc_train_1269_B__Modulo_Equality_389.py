def solve(n,m,a,b):

    temp = []
    b = sorted(b)

    for i in range(n):
        x = (b[0] - a[i])%m
        temp.append(x)


    mini = int(1e9)
    for x in temp:
        ans = []
        for i in range(n):
            ans.append((a[i]+x)%m)

        ans = sorted(ans)
        if ans == b:
            mini = min(mini,x)

    print(mini)


if __name__ == '__main__':
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))

    solve(n,m,a,b)