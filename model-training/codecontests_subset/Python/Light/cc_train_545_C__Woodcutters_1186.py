n=int(input())
a=[]
for i in range(0,n):
    x,y=map(int,input().split())
    a.append([x,y])
if n>1:
    count=2
else:
    count=1
right=[0]*(n)
space=[0]*(n)
right[n-1]=1
for i in range(1,n-1):
    if (a[i][0]-a[i-1][0])>a[i][1] and right[i-1]==0:
        count+=1
    elif  right[i-1]==1 and space[i-1]>a[i][1]:
        count+=1
    elif (a[i+1][0]-a[i][0])>a[i][1]:
        count+=1
        right[i]=1
        space[i]=a[i+1][0]-a[i][0]-a[i][1]
print(count)