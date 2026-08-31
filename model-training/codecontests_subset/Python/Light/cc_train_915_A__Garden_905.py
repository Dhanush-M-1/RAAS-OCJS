n,k=map(int,input().split())
a=list(map(int,input().split()))
a=sorted(a)
for i in a[::-1]:
    if k%i==0:
        print(k//i)
        break