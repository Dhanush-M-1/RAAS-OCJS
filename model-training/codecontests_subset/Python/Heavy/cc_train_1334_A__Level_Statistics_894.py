N=int(input())
for i in range(N):
    n=int(input())
    plays=[]
    clears=[]
    flag=0
    for j in range(n):
        P_C=list(input().split())
        plays.append(int(P_C[0]))
        clears.append(int(P_C[1]))
        if len(plays)!=1:
            if(plays[j]<plays[j-1] or clears[j]<clears[j-1]):
                flag=1
            elif(plays[j]==plays[j-1] and clears[j]!=clears[j-1]):
                flag=1
            elif((plays[j]-plays[j-1])<(clears[j]-clears[j-1])):
                flag=1
        if plays[j]<clears[j]:
            flag=1
    if flag==0:
        print("YES")
    else:
        print("NO")
    
