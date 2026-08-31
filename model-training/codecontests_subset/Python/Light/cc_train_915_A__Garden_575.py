n, k = map(int, input().split())
l = list(map(int, input().split()))
ans = 10 ** 9
for elem in l:
    if k % elem == 0 and k // elem < ans:
        ans = k // elem
print(ans)