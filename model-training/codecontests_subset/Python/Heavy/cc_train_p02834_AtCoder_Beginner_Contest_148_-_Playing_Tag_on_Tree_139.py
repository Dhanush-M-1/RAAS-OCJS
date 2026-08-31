import sys
sys.setrecursionlimit(10**5)

# input
n, u, v = map(int, list(input().split()))

tree = [[] for i in range(n)]
for i in range(n-1):
    a, b = map(int, list(input().split()))
    tree[a-1].append(b-1)
    tree[b-1].append(a-1)

# process
def getdis(idx, num, dis):
    dis[idx] = num
    for i in tree[idx] :
        if dis[i] < 0:
            dis = getdis(i, num+1, dis)
    return dis

dis_u = [-1]*n
dis_u = getdis(u-1, 0, dis_u)
dis_v = [-1]*n
dis_v = getdis(v-1, 0, dis_v)

ans = 0
for i in range(n):
    if dis_u[i] <= dis_v[i]:
        ans = max(ans, dis_v[i]-1)

# output
print(ans)
