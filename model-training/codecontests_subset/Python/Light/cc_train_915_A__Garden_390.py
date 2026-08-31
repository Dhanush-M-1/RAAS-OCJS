n, k = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]
ans = 10 ** 100
for i in a:
    if k % i == 0 and k // i < ans:
        ans = k // i
print(ans)