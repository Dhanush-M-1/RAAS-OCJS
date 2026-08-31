from collections import defaultdict, deque
N, u, v = map(int, input().split())
u -= 1
v -= 1
dic = defaultdict(list)
for i in range(N-1):
  a, b = map(int, input().split())
  dic[a-1] += [b-1]
  dic[b-1] += [a-1]
dist1 = [float('inf')]*N
dist2 = [float('inf')]*N
q1 = deque([u])
q2 = deque([v])
dist1[u] = 0
dist2[v] = 0
while q1:
  e = q1.popleft()
  for p in dic[e]:
    if dist1[p]>dist1[e]+1:
      dist1[p] = dist1[e]+1
      q1 += [p]

while q2:
  e = q2.popleft()
  for p in dic[e]:
    if dist2[p]>dist2[e]+1:
      dist2[p] = dist2[e]+1
      q2 += [p]

ans = -1
j = 0
for i in range(N):
  if ans<dist2[i]-1 and dist1[i]<dist2[i]:
    ans = dist2[i]-1
if u==v:
  ans = 0
print(ans)