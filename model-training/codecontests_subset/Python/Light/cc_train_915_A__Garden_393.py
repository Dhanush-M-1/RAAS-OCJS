n, k = [int(x) for x in input().split()]
arr = [int(x) for x in input().split()]
max_a = 0
for i in range(n):
    if (k % arr[i] == 0):
        if arr[i] > max_a:
            max_a = arr[i]
print(k // max_a)