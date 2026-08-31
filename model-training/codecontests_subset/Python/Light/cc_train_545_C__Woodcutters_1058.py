arr = []
n= int(input())
for _ in range(n):
    arr.append(list(map(int, input().split())))
if n > 1:
    t = 2
else:
    t = 1
for i in range(1, n-1):
    if arr[i][0]- arr[i][1] > arr[i-1][0]:
        t += 1
    elif arr[i][0] + arr[i][1] < arr[i+1][0]:
        t +=1
        arr[i][0] += arr[i][1]
print(t)
