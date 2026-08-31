n = int(input())
arr = [[int(i) for i in input().split(" ")] for j in range(n)]
count = 2 if(n>=2) else 1
for i in range(1,n-1):
    if(arr[i][1]<arr[i][0]-arr[i-1][0]):
        count+=1
    elif(arr[i][1]<arr[i+1][0]-arr[i][0]):
        count+=1
        arr[i][0] += arr[i][1]
print(count)