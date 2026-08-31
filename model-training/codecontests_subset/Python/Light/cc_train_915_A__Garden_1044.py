n,k=input().split()
mx=0
n=int(n)
k=int(k)
a=input().split(" ")
for c in a:
     c=int(c)
     if k%c==0:
         if c>mx:
             mx=c
             
print(int(k/mx))             
    