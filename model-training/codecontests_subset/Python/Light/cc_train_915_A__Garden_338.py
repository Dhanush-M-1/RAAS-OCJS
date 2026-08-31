n,k=0,list(map(int,input().split()))[1]
a=list(map(int,input().split()))
a.sort(reverse=True)
for i in a:
    if k%i==0:
        print(k//i)
        break
