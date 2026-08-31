import sys
from collections import deque



t=int(sys.stdin.readline())

for i in range(t):
    n=int(sys.stdin.readline())#node
    EDGE=[list(map(int,sys.stdin.readline().split())) for i in range(n-1)]

    k1=int(sys.stdin.readline())
    X=list(map(int,sys.stdin.readline().split()))

    k2=int(sys.stdin.readline())
    Y=list(map(int,sys.stdin.readline().split()))

    print("B",Y[0],flush=True)

    yans=int(input())

    if yans in X:
        print("C",yans,flush=True)
    else:
        QUE=deque([yans])

        EDGELIST=[[] for i in range(n+1)]

        for i,j in EDGE:
            EDGELIST[i].append(j)
            EDGELIST[j].append(i)

        checked=[0]*(n+1)

        XLIST=[0]*(n+1)

        for xver in X:
            XLIST[xver]=1

        while QUE:
            now=QUE.pop()
            checked[now]=1
            for ver in EDGELIST[now]:
                if checked[ver]==1:
                    continue
                else:
                    QUE.append(ver)

            if XLIST[now]==1:
                break

        print("A",now,flush=True)

        if int(input()) in Y:
            print("C",now,flush=True)
        else:
            print("C",-1,flush=True)

                
                
            





