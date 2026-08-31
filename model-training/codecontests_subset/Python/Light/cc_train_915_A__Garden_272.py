n, k = map(int, input().split())
l = [int(x) for x in input().split()]
mx = 0

for i in l:
    if k % i == 0:
        mx = max(mx, i)

print(k//mx)