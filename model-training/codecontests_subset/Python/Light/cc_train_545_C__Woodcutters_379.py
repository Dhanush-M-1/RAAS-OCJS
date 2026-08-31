n = int(input())

arr = []
for _ in range(n) :
    arr.append(tuple(map(int, input().split())))
    
count = 0
occ = arr[0][0]
for i in range(1, n-1):
    if arr[i][0]-arr[i][1] > occ :
        occ = arr[i][0]
        count = count + 1
    elif arr[i][0]+arr[i][1] < arr[i+1][0] :
        occ = arr[i][0]+arr[i][1]
        count = count + 1
    else :
        occ = arr[i][0]

if n > 1 :
    count = count + 2
else :
    count = 1
    
print(count)