import sys
import bisect
input=sys.stdin.readline
#t=int(input())
def takeSecond(elem):
    return elem[1]
    
t=1
for _ in range(t):
    #n,m=map(int,input().split())
    n=int(input())
    l=[]
    for i in range(n):
        l.append(list(map(int,input().split())))
    ans=1
    prevl=l[0][0]
    for i in range(1,n):
        if l[i][0]-l[i][1]>prevl:
            prevl=l[i][0]
            ans+=1
        else:
            if i<n-1:
                if l[i][0]+l[i][1]<l[i+1][0]:
                    prevl=l[i][1]+l[i][0]
                    ans+=1
                else:
                    prevl=l[i][0]
            else:
                ans+=1
    print(ans)        
        