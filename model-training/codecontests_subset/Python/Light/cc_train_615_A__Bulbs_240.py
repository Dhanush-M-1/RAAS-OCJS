n,m=map(int,input().split())
arr=[0]*m
for i in range(n):
    a=list(map(int,input().split()))
    for i in range(1,len(a)):
        arr[a[i]-1]=1 
if(arr.count(1)==m):
    print("YES")
else:
    print("NO")
        
        
    