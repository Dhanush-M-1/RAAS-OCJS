n = int(input())
ai = list(map(int,input().split()))
ans1 = 0
ans2 = 0
for i in range(n):
    if ai[i]> 500000:
        break
    ans1 = ai[i]-1
for i in range(n):
    if ai[i]> 500000:
        ans2 = 1000000- ai[i]
        break
print(max(ans1,ans2))
