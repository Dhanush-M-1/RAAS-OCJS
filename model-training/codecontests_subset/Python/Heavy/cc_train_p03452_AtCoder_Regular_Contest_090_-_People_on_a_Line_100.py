N, M = map(int, input().split())

# union-find改良
parent = list(range(N+1))
rank = [0] * (N+1)
pardist = [0] * (N+1) # ルートとの距離

def getRoot(x):
  if parent[x] == x:
    return x, 0
  else:
    # ルートに繋ぎ変える
    parent[x], dist = getRoot(parent[x])
    # ルートとの距離に更新
    pardist[x] += dist
    return parent[x], pardist[x]

def unite(left, right, dist):
  lRoot, lPardist = getRoot(left)
  rRoot, rPardist = getRoot(right)
  # print(parent)
  # print(pardist)
  if lRoot == rRoot:
    # 矛盾がないかチェック
    if -(rPardist - lPardist) != dist:
      print('No')
      exit()
  else:
    # 矛盾は起きない
    # ルート間の距離だけ更新して併合
    if rank[lRoot] < rank[rRoot]:
      parent[lRoot] = rRoot
      pardist[lRoot] = dist + rPardist - lPardist
    else:
      parent[rRoot] = lRoot
      pardist[rRoot] = -(dist + rPardist - lPardist)
      if rank[lRoot] == rank[rRoot]:
        rank[lRoot] += 1

for i in range(M):
  l, r, d = map(int, input().split())
  unite(l, r, d)

print('Yes')