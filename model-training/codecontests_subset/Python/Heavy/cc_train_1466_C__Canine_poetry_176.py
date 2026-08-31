import math
from collections import defaultdict
from sys import stdin
input=stdin.readline
T=int(input())
for _ in range(T):
    s=input()
    s=list(s)
    s.pop()
    if len(s)==1:
        print(0)
    elif len(s)==2:
        if s[0]!=s[1]:
            print(0)
        else:
            print(1)
    else:
        c=0
        for i in range(1,len(s)):
            if s[i]==s[i-1]:
                s[i]='*'
                c+=1
            elif i-2>=0 and s[i-2]==s[i]:
                s[i]='*'
                c+=1
        print(c)
