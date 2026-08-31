n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int,input().rstrip().split())))

t = 1
s = arr[0][0]
for i in range(1,n):
    if i+1 < n:
        if arr[i][0] - arr[i][1] > s:
            s = arr[i][0]
            t+=1
        elif arr[i][0] + arr[i][1] < arr[i+1][0]:
            s = arr[i][0] + arr[i][1]
            t+=1
        else:
            s = arr[i][0]
t+=1
if n == 1:
    t = 1
print(t)
            