n=int(input())
a=[]
for i in range(n):
    x,h=map(int,input().split())
    a.append([x,h])
num=1
i=1
while i<n-1:
    if a[i][1]<a[i][0]-a[i-1][0]:
        num+=1
    else:
        if a[i][1]<a[i+1][0]-a[i][0]:
            num+=1
            a[i][0]+=a[i][1]
    i+=1
if n>=2:
    num+=1
print(num)
