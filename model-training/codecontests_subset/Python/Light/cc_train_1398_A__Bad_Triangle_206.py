Q=int(input())
for q in range(Q):
    N=int(input())
    L=list(map(int,input().split()))
    L.sort()
    if L[-1]>=(L[0]+L[1]):
        print(1,2,N)
    else:
        print(-1)