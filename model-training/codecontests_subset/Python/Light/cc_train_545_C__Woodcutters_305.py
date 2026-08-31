n=int(input())
arr=[]
for i in range(n):
    x,h=map(int,input().split())
    arr.append([x,h])
arr.append([1e18,0])
prev=-1e18 
ans=0
for i in range(n):
    if (arr[i][0]-arr[i][1])>prev:
        ans+=1 
        prev=arr[i][0]
    elif (arr[i][0]+arr[i][1])<arr[i+1][0]:
        ans+=1 
        prev=arr[i][0]+arr[i][1]
    else:
        prev=arr[i][0]
print(ans)