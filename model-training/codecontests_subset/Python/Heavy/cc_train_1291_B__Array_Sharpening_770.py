import sys
input = sys.stdin.readline

t=int(input())

for tests in range(t):
    n=int(input())
    A=list(map(int,input().split()))

    LMAX=[-1]*n

    for i in range(n):
        if A[i]>=i:
            LMAX[i]=A[i]
        else:
            break

    RMAX=[-1]*n

    for i in range(n):
        if A[n-1-i]>=i:
            RMAX[n-1-i]=A[n-1-i]
        else:
            break

    #print(LMAX,RMAX)

    for i in range(n):
        if LMAX[i]!=-1 and RMAX[i]!=-1:
            print("Yes")
            break
    else:
        print("No")

    
        
        
