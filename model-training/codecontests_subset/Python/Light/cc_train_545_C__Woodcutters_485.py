n=int(input())
A=[]
for i in range(n):
    A.append(list(map(int,input().split())))
if n==1 or n==2:
    print(n)
else:
    s=2
    for i in range(1,n-1):
        if A[i][0]-A[i][1]>A[i-1][0]:
            s=s+1
        elif A[i][0]+A[i][1]<A[i+1][0]:
            s=s+1
            A[i][0]+=A[i][1]
    print(s)