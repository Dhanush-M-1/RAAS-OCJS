n=int(input())
A=[]
B=[]
for i in range(n):
    a,b=map(int,input().split())
    A.append(a)
    B.append(b)
if n==1:
    print('1')
elif n==2:
    print('2')
else:
    s=2
    for i in range(1,n-1):
        if A[i]-A[i-1]>B[i]:
            s=s+1
        elif A[i+1]-A[i]>B[i]:
            s=s+1
            A[i]=A[i]+B[i]
        else:
            pass
    print(s)
