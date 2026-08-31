from collections import Counter
from sys import stdin    
t=int(stdin.readline())
while t:
    s,c=input().split()
    s=list(s)
    b=sorted(s)
    if s!=b:
        for i in range(len(b)):
            if s[i]!=b[i]:
                temp=s[i]
                s[i]=b[i]
                x=s[i]
                break
        for i in range(len(s)-1,-1,-1):
            if s[i]==x:
                s[i]=temp
                break
    s=''.join(s)
    if s<c:
        print(s)
    else:
        print('---')

    t-=1