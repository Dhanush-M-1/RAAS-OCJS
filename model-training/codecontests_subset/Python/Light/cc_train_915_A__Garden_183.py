n, k = [int(x) for x in input().split(' ')]
a = [int(x) for x in input().split(' ')]
for i in range(1, k + 1):
    if k % i == 0 and k // i in a:
        ans = i
        break
print(ans)