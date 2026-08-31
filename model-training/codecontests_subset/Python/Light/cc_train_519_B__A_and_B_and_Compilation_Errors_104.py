n=int(input())
a=sorted(list(map(int,input().split())))
b=sorted(list(map(int,input().split())))
c=sorted(list(map(int,input().split())))
cnt=cnt1=0
for i in range(n-1) :
    if a[i]!=b[i] :
        print(a[i])
        cnt1=cnt1+1
        break
if cnt1==0 :
    print(a[-1])
for j in range(n-2) :
    if b[j]!=c[j] :
        print(b[j])
        cnt=cnt+1
        break
if cnt==0 :
    print(b[-1])