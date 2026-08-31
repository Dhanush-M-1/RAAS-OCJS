
R = lambda:map(int,input().split())

arr = input().split()
print(*arr)
n, = R()
for i in range(n):
    x, y = input().split()
    arr[arr.index(x)] = y
    print(*arr)
        