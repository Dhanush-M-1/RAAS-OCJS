from collections import defaultdict
for _ in range(int(input())):
    N=int(input())
    Pairs=[]
    for i in range(N):
        Pairs.append(list(map(int,input().split())))
    FLAG=0
    for i in range(N):
        for j in range(i+1,N):
            if Pairs[j][0]<Pairs[i][0] or Pairs[j][1]<Pairs[i][1]:
                FLAG=1
                break
        if FLAG==1:
            break
    if FLAG==1:
        print("NO")
    else:
        Pairs.insert(0,[0,0])
        N=len(Pairs)
        for i in range(N-1):
            if Pairs[i+1][0]-Pairs[i][0]<Pairs[i+1][1]-Pairs[i][1]:
                FLAG=1
                break
        if FLAG==1:
            print("NO")
        else:
            print("YES")