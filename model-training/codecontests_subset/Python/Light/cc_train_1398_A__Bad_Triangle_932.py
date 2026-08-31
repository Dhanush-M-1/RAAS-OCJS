# http://codeforces.com/contest/1398/problem/A
# A. Bad Triangle

t = int(input())
for test in range(0, t):
    n = int(input())
    a = list(map(int, input().rstrip().split()))
    ai = a[0]
    aj = a[1]
    ak = a[n-1]
    if (ai+aj)>ak:
        print("-1\n")
    else:
        print("%d %d %d\n" % (1, 2, n))