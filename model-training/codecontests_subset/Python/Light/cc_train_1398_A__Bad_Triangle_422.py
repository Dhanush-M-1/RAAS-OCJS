for _ in range(int(input())):
    N=int(input())
    A=list(map(int,input().split()))
    t=A[0]+A[1]
    temp=0
    for i in range(2,N):
        if(A[i]>=t):
            temp=1
            print(1,2,i+1)
            break
    if(temp==0):
        print(-1)