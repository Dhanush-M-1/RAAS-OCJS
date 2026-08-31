n, m = map(int, input().split())
w = list(map(int, input().split()))
b = list(map(int, input().split()))
b = list(map(lambda x: x-1, b))
acc = [[0] for _ in range(n)]

for i in range(n):
    for j in range(m):
        acc[i].append(acc[i][-1]+(1 if b[j]==i else 0))

ans = 0

for i in range(n):
    ids = []
    
    for j in range(m):
        if b[j]==i:
            ids.append(j)
        
    ids.append(m)

    for j in range(len(ids)-1):
        cnt = 0
        
        for k in range(n):
            if acc[k][ids[j+1]]-acc[k][ids[j]+1]>=1:
                cnt += 1
        
        ans += cnt*w[i]

print(ans)