import math
"""
int(input())
map(int,input().split())
list(map(int,input().split()))

"""
t=1
for _ in range(t):
    n=int(input())
    A=list(map(int,input().split()))
    A.sort()
    s=sum(A)
    a=0
    b=0
    for i in range(n):
        if(A[i]==100):
            a+=1
        else:
            b+=1
    if((s//2)%100!=0):
        print("NO")
        break
    else:
        ans="NO"
        x=s//2
        for i in range(a+1):
            for j in range(b+1):
                if((100*i+200*j)==x):
                    ans="YES"
    print(ans)
            
            