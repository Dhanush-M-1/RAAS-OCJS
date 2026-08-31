
n=int(input())
l=[]
for i in range(n):
    l+=list(map(int,input().split()))
c=2
s=l[0]
for i in range(1,n-1):
    j=2*i
    if l[j]-s>l[j+1]:
        c+=1
        s=l[j]
        continue
    if l[j]+l[j+1]<l[j+2]:
        c+=1
        s=l[j]+l[j+1]
        continue
    s=l[j]
print(n if n<2 else c)
