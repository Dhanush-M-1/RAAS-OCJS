def shift():
    a=A.pop(0)
    A.append(a)
    a=A1.pop(0)
    A1.append(a)
def count(A):
    c=A[0]
    n=0
    A0=[]
    A1=[A[0]]
    for i in range(len(A)):
        if c==A[i]:
            n+=1
        else:
            A0.append(n)
            A1.append(A[i])
            n=1
            c=A[i]
    A0.append(n)
    return A0,A1
def check(x):
    for i in range(len(A1)):
        if (A1[i]+x)%m!=B1[i]:
            return False
    return True
n,m=map(int,input().split())
turns=0
A0=sorted(list(map(int,input().split())))
B0=sorted(list(map(int,input().split())))
if A0==B0:
    print(0)
else:
    A,A1=count(A0)
    B,B1=count(B0)
    turns=0
    x=m+1
    while turns<n:
        if A==B:
            x1=(m+B1[-1]-A1[-1])%m
            if x1<x and check(x1):
                x=x1
        shift()
        turns+=1
    print(x)