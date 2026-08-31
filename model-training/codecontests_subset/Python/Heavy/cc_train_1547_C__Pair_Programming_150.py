import sys
input=sys.stdin.readline
#sys.stdin=open('input.txt','r')

for _ in range(int(input())):
    xx=input()
    k,n,m=map(int,input().split())
    ar=list(map(int,input().split()))
    br=list(map(int,input().split()))
    
    i=0
    j=0
    ans=[]
    for ii in range(n+m):
        if(i<n and j<m):
            if(ar[i]<=br[j]):
                ans.append(ar[i])
                i+=1
            else:
                ans.append(br[j])
                j+=1
        elif(i<n):
            ans.append(ar[i])
            i+=1
        else:
            ans.append(br[j])
            j+=1
    flag=True
    for i in ans:
        if(i==0):
            k+=1
        else:
            if(i>k):
                flag=False
                break
    if(flag):
        print(*ans)
    else:
        print(-1)