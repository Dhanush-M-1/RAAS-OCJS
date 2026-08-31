from collections import Counter,defaultdict
from sys import stdin, stdout
input = stdin.readline
I =lambda:int(input())
M =lambda:map(int,input().split())
LI=lambda:list(map(int,input().split()))
for _ in range(I()):
    n=I()
    a=LI();flag=0
    if n==1:
        print("Yes")
    else:
        flag=1;c=max(a[0],a[-1])
        for i in range((n+1)//2):
            if i!=((n+1)//2)-1:
                if a[i]>=i and a[(n-1)-i]>=i:
                    continue
                else:
                    flag=0;break
            else:
                if n%2==1:
                    if a[i]<i:flag=0;break
                else:
                    if a[i]==a[(n-1)-i] and a[i]==i:
                        flag=0;break 
                    elif a[i]<i or a[(n-1)-i]<i:
                        flag=0;break
        if flag:
            print("Yes")
        else:
            print("No")
                    





        
