# -*- coding: utf-8 -*-
def change(a,b):
    a=list(a);b=list(b)
    if a<b:
        return(''.join(a))
    else:
        x=sorted(a)
        for i in range(len(a)):
            if a[i]!=x[i]:
                for j in range(1,len(a)+1):
                    if a[-j]==x[i]:
                        a[-j]=a[i]
                        a[i]=x[i]
                        break
                break
        if a<b:
            return(''.join(a))
        if a>=b:
            return('---')
n=int(input())
ans=[]
for i in range(n):
    a,b=input().split()
    ans.append(change(a,b))
[print(j) for j in ans]
