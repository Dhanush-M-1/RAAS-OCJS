n, k = map(int, input().split())
num = list(map(int, input().split()))
ans = 1000000000000000000
for i in range(len(num)):
    if k % num[i] == 0 and k // num[i] < ans:
        ans = k // num[i]
print(ans)