T = int(input())


def solve():
    n = int(input())
    a = list(map(int, input().split()))
    #print(a[-1])
    if(a[0] + a[1] <= a[-1]):
        print("%d %d %d" % (1, 2, n))
    else:
        print(-1)


for t in range(T):
    solve()
