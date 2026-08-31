def do():
    n = int(input())
    dat = list(map(int, input().split()))
    dat.sort()
    a = dat[0] + dat[1]
    for i in range(2, n):
        if dat[i] >= a:
            print(1,2, i+1)
            return
    print(-1)


q = int(input())
import bisect
for _ in range(q):
    do()