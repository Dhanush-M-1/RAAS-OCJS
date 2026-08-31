input=__import__('sys').stdin.readline
from math import log 
n,q = map(int,input().split())
lis = list(map(int,input().split()))
has1=[0]*(33)
for i in lis:
    a = int(log(i,2))
    has1[a]+=1
c=1 
#print(has1)
for _ in range(q):
    no = int(input())
    c=1
    flag=1
    ans=0
    has=has1[:]
    for i in range(33):
        if c & no:
#            print(c)
            if has[i]>0:
                has[i]-=1
                ans+=1
            else:
                k=0
                c1=2
                for j in range(i-1,-1,-1):
                    k+=has[j]/c1
                    c1*=2
#                print(k,ans,'ans')    
                if k<1:
                    flag=False
                    break
                k=0
                c1=2
                for j in range(i-1,-1,-1):
                    req = 1-k
                    if req>=has[j]/c1:
                        ans+=has[j]
                        k+=has[j]/c1
                        has[j]=0
                    else:
#                        print(req,c1,ans)
                        ans+=(req)*c1
                        has[j]=(has[j]/c1-req)*c1
                        break
                    c1*=2    
        c*=2
    if flag:
        print(int(ans))
    else:
        print(-1)    



