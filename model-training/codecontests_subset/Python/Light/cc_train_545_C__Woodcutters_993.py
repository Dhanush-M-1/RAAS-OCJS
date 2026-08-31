n=int(input())
x,h=[],[]
for i in range(n):
    a,b=map(int,input().split())
    x.append(a)
    h.append(b)
l=x[0]+1
count=1
for j in range(1,n-1):
    if x[j]-l>=h[j]:
        count+=1
        l=x[j]+1
    elif x[j+1]-x[j]>h[j]:
        count+=1
        l=x[j]+h[j]+1
    else:
        l=x[j]+1
if n==1:
    count-=1
print(count+1)