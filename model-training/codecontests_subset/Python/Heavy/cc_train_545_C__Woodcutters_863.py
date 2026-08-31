n = int(input())
arr = []
for i in range(n):
    arr.append(tuple(map(int,input().split())))
right=stay=0; left=1
if n>1 and arr[0][0]+arr[0][1]<arr[1][0]: right = 1
for i in range(1,n):
    nstay,nleft,nright = stay,left,right
    nstay = max(stay,left)
    if arr[i-1][0]+arr[i-1][1]<arr[i][0]:
        nstay = max(nstay,right)
    if arr[i][0]-arr[i][1]>arr[i-1][0]:
        nleft = 1+max(left,stay)
    if arr[i][0]-arr[i][1]>arr[i-1][0]+arr[i-1][1]:
        nleft = max(nleft,1+right)
    nright = max(stay,left,right)
    if i+1<n and arr[i][0]+arr[i][1]<arr[i+1][0]:
        nright += 1
    stay,left,right = nstay,nleft,nright
right += 1
print(max(stay,left,right))