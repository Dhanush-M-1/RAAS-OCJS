n,k=list(map(int,input().split()))
a=list(map(int,input().split()))
a=sorted(a)
length=len(a)
for i in range(1,length+1):
    if k%a[length-i]==0:
        print(k//a[length-i])
        break
        