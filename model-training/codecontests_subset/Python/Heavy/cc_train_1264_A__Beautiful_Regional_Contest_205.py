from itertools import groupby
t = int(input())
for _ in range(0,t):
    n = int(input())
    lst = [int(i) for i in input().split()]
    ans = [len(list(g)) for k,g in groupby(lst)]
    ff = []
    ss = 0
    r = n//2
    bb = -1
    for i in range(0,len(ans)):
        if ss+ans[i] <= r:
            ss += ans[i]
        else:
            bb = i
            break
    g = ans[0]
    s,b = 0,0
    for i in range(1,bb):
        if s <= g:
            s += ans[i]
        else:
            b += ans[i]
    if g+s+b <= r and g < s and g < b:
        print(g,s,b)
    else:
        print(0,0,0)
