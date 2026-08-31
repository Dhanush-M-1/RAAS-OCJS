import sys
input=sys.stdin.readline

def main():
    n,k=map(int,input().split())
    A,B,C=[],[],[]
    for i in range(n):
        n,a,b=map(int,input().split())
        if(a==1 and b==1):
            A.append(n)
        elif(a==1 and b==0):
            B.append(n)
        elif(a==0 and b==1):
            C.append(n)

    B.sort()
    C.sort()
    v=min(len(B),len(C))
    for i in range(v):
        A.append(B[i]+C[i])

    if(len(A)<k):
        print(-1)

    else:
        A.sort()
        ans=0
        for i in range(k):
            ans=ans+A[i]

        print(ans)

main()
