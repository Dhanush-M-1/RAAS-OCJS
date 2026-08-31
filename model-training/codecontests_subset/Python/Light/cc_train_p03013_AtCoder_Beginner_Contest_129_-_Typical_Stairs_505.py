n,m = map(int, input().split())
u = [0]*(n+1)
for i in range(m):
    u[int(input())] = 1
ll = [0]*(n+2)
ll[1] = 1
for i in range(2,n+2):
    if not u[i-1]:
        ll[i] = ll[i-1] + ll[i - 2]
print(ll[-1] % 1000000007)
