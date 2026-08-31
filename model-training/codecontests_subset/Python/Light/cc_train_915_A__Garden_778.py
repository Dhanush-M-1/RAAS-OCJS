n, k = map(int, input().strip().split())
arr = [int(v) for v in input().strip().split()]
arr.sort()
ans = 0
arr = arr[::-1]
for el in arr:
    if k%el == 0:
        ans = k//el
        break
print(ans)