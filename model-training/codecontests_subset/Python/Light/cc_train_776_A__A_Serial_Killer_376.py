A=input().split()
n=int(input())
print(A[0]," ", A[1])
for i in range(n):
    B=input().split()
    if A[0]==B[0]:
        A[0]=B[1]
    else:
        A[1]=B[1]
    print(A[0]," ", A[1])