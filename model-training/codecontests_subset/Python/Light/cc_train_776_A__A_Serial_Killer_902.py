arr = input().split()

n = int(input())

for i in range(n):
    print(*arr)
    x , y = input().split()
    if(arr[0] == x): arr[0] = y
    else: arr[1] = y

print(*arr)

