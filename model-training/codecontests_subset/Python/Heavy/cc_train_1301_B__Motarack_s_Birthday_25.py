import sys
input=sys.stdin.readline
t=int(input())
for you in range(t):
    n=int(input())
    l=input().split()
    li=[int(i) for i in l]
    l=[]
    start=0
    end=0
    done=0
    for i in range(n):
        if(li[i]==-1):
            if(done):
                end+=1
            else:
                start=i
                end=i
                done=1
        else:
            if(done):
                l.append((start,end))
                done=0
    if(done):
        l.append((start,end))
        done=0
    lo=[]
    maxa=0
    for i in l:
        n1=i[0]
        n2=i[1]
        if(n1>0):
            lo.append(li[n1-1])
        if(n2<n-1):
            lo.append(li[n2+1])
    if(lo==[]):
        ans=0
    elif(len(lo)==1):
        ans=lo[0]
    else:
        lo.sort()
        ans=(lo[0]+lo[-1])//2
    for i in range(n):
        if(li[i]==-1):
            li[i]=ans
    maxa=0
    for i in range(1,n):
        maxa=max(maxa,abs(li[i]-li[i-1]))
    print(maxa,end=" ")
    print(ans)