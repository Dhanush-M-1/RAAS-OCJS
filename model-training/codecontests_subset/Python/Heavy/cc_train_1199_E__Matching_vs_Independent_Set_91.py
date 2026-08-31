import sys
input = sys.stdin.readline

T=int(input())

for testcases in range(T):
    n,m=map(int,input().split())
    EDGE=[[0,0]]+[list(map(int,input().split())) for i in range(m)]

    USED=[0]*(3*n+1)
    count=0
    ANS=[]

    for i in range(1,m+1):
        x,y=EDGE[i]

        if USED[x]==0 and USED[y]==0:
            count+=1
            ANS.append(i)
            USED[x]=1
            USED[y]=1

            if count==n:
                print("Matching")
                print(*ANS)
                break

    else:
        ANS=[]
        count=0
        for i in range(1,3*n+1):
            if USED[i]==0:
                count+=1
                ANS.append(i)

                if count==n:
                    print("IndSet")
                    print(*ANS)
                    break
                    
            

    
