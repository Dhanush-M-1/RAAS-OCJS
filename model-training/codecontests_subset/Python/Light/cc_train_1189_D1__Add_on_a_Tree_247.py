n=int(input())
arr=[0]*n
for i in range(0,n-1):
    x,y=map(int,input().split())
    arr[x-1]+=1
    arr[y-1]+=1
for i in range(0,n):
    if arr[i]==2:
        print("NO")
        exit()
print("YES")