import sys
t=int(input())
while t:
    n=int(input())
    #n,m=map(int,input().split())
    #s=input()
    l=list(map(int,input().split()))
    #b=list(map(int,input().split()))
    ch=0
    j=0
    ind=0
    cnt=0
    for i in range(n):
        if l[i]>=j :
            j+=1
        else:
            j=l[i-1]-1    
            ind=i
            break
        if i==n-1:
            ch=1
    for i in range(ind,n):
        if l[i]>=j and j>=0:
            j-=1
        elif j>=0 and l[i]<j:
            j=l[i]
            j-=1
        else:
            break
        if i==n-1:
            ch=1
    j=l[0]        
    for i in range(n):
        if l[i]>=j and j>=0:
            j-=1
        elif j>=0 and l[i]<j:
            j=l[i]
            j-=1
        else:
            break
        if i==n-1:
            ch=1
    if ch==1:
        print("Yes")
    else:
        print("No")
        
    t-=1