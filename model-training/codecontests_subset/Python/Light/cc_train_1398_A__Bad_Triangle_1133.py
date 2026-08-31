def triangle(A):
    n=len(A)
    z=A[-1]
    x=A[0]
    y=A[1]
    if x+y>z:
        print(-1)
    else:
        print(1,2,n)
t=int(input())
for i in range(t):
    n=int(input())
    A=[int(z) for z in input().split()][:n]
    triangle(A)