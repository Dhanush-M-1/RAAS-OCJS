n,k=map(int,input().split())
a=list(map(int,input().split()))
a.sort(reverse=True)
#print (a)
for i in range(n):
    if k%a[i]==0:
        print (k//a[i])
        break