from math import *

n, s = map(int, input().split())
if n==1:
    print(abs(int(input())-s))
else:
    ls = list(map(int, input().split()))
    ls.sort()
    start = ls[(n-3)//2]
    end = ls[(n+1)//2]
    if s in list(range(start, end+1)):
        print(abs(ls[(n-1)//2]-s))
    elif ls[(n-1)//2]<s:
        index = (n-1)//2
        count = 0
        while index!=n:
            if ls[index]<s:
                count+=s-ls[index]
            index+=1
        print(count)
    else:
        index = (n-1)//2
        count = 0
        while index!=-1:
            if ls[index]>s:
                count+=ls[index]-s
            index-=1
        print(count)
