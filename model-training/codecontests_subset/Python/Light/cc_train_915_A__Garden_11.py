n,k=map(int,input().split())
a=list(map(int,input().split()))
gc=[]
a.sort(reverse=True)
for i in a:
    if k%i==0:
        print(k//i)
        break

