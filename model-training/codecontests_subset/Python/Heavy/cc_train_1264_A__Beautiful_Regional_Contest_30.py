from itertools import groupby
t = int(input())
for _ in range(t):
    n = int(input())
    arr = [int(x) for x in input().split()]
    ans = [len(list(g)) for k, g in groupby(arr)]
    g=ans[0]
    s=0
    b=0
    ind = 1

    while(g+s+b <= len(arr)//2):
        if ind==len(ans):
            break
        if g+s+b+ans[ind]>len(arr)//2:
            break
        if g>=s:
            s+=ans[ind]
        else:
            b+=ans[ind]
        ind+=1

    if (g<s) and (g<b):
        print (g, s, b)
    else:
        print (0, 0, 0)