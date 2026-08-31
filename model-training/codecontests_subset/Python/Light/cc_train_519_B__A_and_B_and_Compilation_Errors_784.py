n=int(input())
a=sorted(map(int,input().split()))
b=sorted(map(int,input().split()))
c=sorted(map(int,input().split()))
i=0; f=0
while i<n-1:
    if a[i]!=b[i]: f=1; print(a[i]); break
    i+=1
if f==0: print(a[n-1])
i=0; f=0
while i<n-2:
    if b[i]!=c[i]: f=1; print(b[i]); break
    i+=1
if f==0: print(b[n-2])