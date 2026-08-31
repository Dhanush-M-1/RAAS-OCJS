n=int(input())
l=list(map(int,input().split()))
a=1
b=10**6
x=1
y=0
s=0
s1=0
i=0
for i in range(n):
    if l[i]>500000:
        break
    y=l[i]
    s+=(y-x)
    x=y
x=10**6
#print(i)
for j in range(n-1,-1,-1):
    if l[j]<=500000:
        break
    y=l[j]
    s1+=(x-y)
    x=y
#print(s)
#print(s1)
print(max(s,s1))    
        
