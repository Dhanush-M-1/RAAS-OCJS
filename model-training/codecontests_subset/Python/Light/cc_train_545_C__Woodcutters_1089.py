n = int(input())
arr = [list(map(int, input().split())) for i in range(n)]
ans = 2

for i in range(1, n-1):
    x, h = arr[i]
    if x-h > arr[i-1][0]:
        ans += 1
    elif x+h < arr[i+1][0]:
        ans += 1
        arr[i][0] += h 

if n > 1:
    print(ans)
else:
    print(1)