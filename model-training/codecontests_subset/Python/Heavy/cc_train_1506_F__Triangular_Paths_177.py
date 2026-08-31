import sys
input = sys.stdin.readline
from operator import itemgetter

t=int(input())
for tests in range(t):
    n=int(input())
    R=list(map(int,input().split()))
    C=list(map(int,input().split()))

    X=[]
    for i in range(n):
        X.append((R[i],C[i]))

    X.sort(key=itemgetter(0))

    if X[0][0]!=1:
        X=[(1,1)]+X

    #print(X)

    ANS=0
    for i in range(len(X)-1):
        nowx,nowy=X[i]
        nexx,nexy=X[i+1]

        if (nowx-nowy)%2==0:
            if (nowx-nowy)==nexx-nexy:
                ANS+=nexx-nowx
            else:
                ANS+=((nexx-nexy)-(nowx-nowy))//2
            
        else:
            ANS+=((nexx-nexy)-(nowx-nowy)+1)//2

    print(ANS)
            
            

        

    
    
                        

    
