n,k=map(int,input().split())
a=list(map(int,input().split()))
a=sorted(a,reverse=True,key=int)
for i in a:
   if k%i==0:
       print(k//i)
       break