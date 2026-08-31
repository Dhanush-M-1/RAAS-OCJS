#Woodcutters - Greedy solution
n = int(input())
l = [list(map(int,input().split())) for _ in range(n)]
if n == 1:
    print(1)
    exit()

ans = 2
for i in range(1,n-1):
    x,h = l[i][0],l[i][1]
    if x-h > l[i-1][0]:
        ans += 1
        continue

    if x+h < l[i+1][0]:
        ans += 1
        l[i][0] = x+h

print(ans)