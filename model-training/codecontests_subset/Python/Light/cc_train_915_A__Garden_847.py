n, k = map(int, input().split())
a = list(map(int, input().split()))
ans = []
for i in a:
    if k % i == 0:
       ans.append(k // i)
print(min(ans))


























