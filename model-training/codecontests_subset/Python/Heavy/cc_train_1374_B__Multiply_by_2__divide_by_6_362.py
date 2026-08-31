#dt = {} for i in x: dt[i] = dt.get(i,0)+1
import sys;input = sys.stdin.readline
inp,ip = lambda :int(input()),lambda :[int(w) for w in input().split()]

for _ in range(inp()):
    n = inp()
    ct = 0
    cnt = 0
    flag = 0
    while n != 1:
        if n%6 == 0:
            n //= 6
            ct += 1
            cnt = 0
        else:
            if cnt > 2:
                flag = 1
                break
            n *= 2
            ct += 1
            cnt += 1
    if flag:
        print(-1)
    else:
        print(ct)
