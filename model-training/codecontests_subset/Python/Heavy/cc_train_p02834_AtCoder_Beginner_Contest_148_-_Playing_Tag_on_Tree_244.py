import sys

sys.setrecursionlimit(10**6)

N, u, v = map(int, input().split())
tree = [[] for _ in range(N)]
for _ in range(N-1):
  a, b = map(int, input().split())
  tree[a-1].append(b-1)
  tree[b-1].append(a-1)
#print(tree)

def calc_dist(dlist, n, dist, nnode):
  for c in tree[n]:
    if c == nnode:
      continue
    dlist[c] = dist
    calc_dist(dlist, c, dist+1, n)
    
u_dist_list = [0] * N
calc_dist(u_dist_list, u-1, 1, -1)
#print(u_dist_list)

v_dist_list = [0] * N
calc_dist(v_dist_list, v-1, 1, -1)
#print(v_dist_list)

ans = 0
for i in range(N):
  if (v_dist_list[i] - u_dist_list[i]) > 0 and v_dist_list[i] > ans:
    ans = v_dist_list[i] - 1
    
print(ans)