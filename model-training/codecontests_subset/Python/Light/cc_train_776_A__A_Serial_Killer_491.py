a, b = input().split()
n = int(input())

arr = []
for i in range(n):
    t = input().split()
    arr.append(t)

print(a, b)
for i in range(n):
    if arr[i][0] == a:
        a = arr[i][1]
    else:
        b = arr[i][1]
    print(a, b)