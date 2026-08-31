n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int,input().split())))
arr.sort()
if n==1:
    cnt = 1
else:
    cnt = 2
prev = arr[0][0]
for i in range(1,n-1):
    if abs(arr[i][0]-prev)>arr[i][1]:
        prev = arr[i][0]
        cnt+=1
    elif abs(arr[i][0]-arr[i+1][0])>arr[i][1]:
        prev = arr[i][0]+arr[i][1]
        cnt+=1
    else:
        prev = arr[i][0]
print(cnt)
