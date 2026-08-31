n,m = map(int,input().split())
wi  = list(map(int,input().split()))
bi  = list(map(int,input().split()))
ai = [-1] * n
ai2 = [-1] * n
num = 0
for i in range(m):
    bi[i] -= 1
    if ai[bi[i]] == -1:
        ai[bi[i]] = 1
        ai2[num] = bi[i]
        num += 1
for i in range(n):
    if ai[i] == -1:
        ai2[num] = i
        num += 1
ans = 0
for i in range(m):
    j = 0
    num = ai2[0]
    while j < n:
        num2 = ai2[j]
        ai2[j] = num
        num = num2
        if num == bi[i]:
            ai2[0] = num
            break
        ans += wi[num]
        j += 1
print(ans)
        
