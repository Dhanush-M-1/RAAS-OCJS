def solve(arr):
    for i in arr:
        if i == 0:
            return ("NO")
    return ("YES")
n, m = map(int, input().split())
li = [0] * m
for i in range(n):
    arr = list(map(int, input().split()))
    arr.pop(0)
    for j in arr:
        li[j - 1] = 1
print(solve(li))