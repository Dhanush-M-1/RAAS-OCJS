# -*- coding: utf-8 -*-
for _ in [0]*int(input()):
    n=int(input())
    a=['0']*3
    s = list(map(int, input().split()))
    if n>=5:
        i=j=m=0

        for x in range(1,n):
            if not s[x]==s[x-1]:
                if i==0:
                    i=x
                    if i>int(n/3):break
                elif j==0:
                    if x > i * 2:
                        j=x-i
                elif x<=n/2 and x-j-i>i:
                    m=x-j-i
                    a=[str(i),str(j),str(m)]
                elif x>n/2: break


    print(" ".join(a))

