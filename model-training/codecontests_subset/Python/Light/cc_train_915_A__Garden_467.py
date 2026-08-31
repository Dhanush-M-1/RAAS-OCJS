from operator import itemgetter
#int(input())
#map(int,input().split())
#[list(map(int,input().split())) for i in range(q)]
#print("YES" * ans + "NO" * (1-ans))
n,k = map(int,input().split())
ai = list(map(int,input().split()))
ans = 0
ai.sort()
for i in range(n-1,-1,-1):
    if k % ai[i] == 0:
        ans = k // ai[i]
        break
print(ans)
