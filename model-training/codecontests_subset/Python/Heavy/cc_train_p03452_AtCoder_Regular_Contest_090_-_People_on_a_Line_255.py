def find(x, U, r, w): #x: ノード名、U:前のノードの配列 w:前のノードからの距離の配列、r:深さ
  if x == U[x]:
    return (x, w[x])
  else:
    k = find(U[x], U, r, w)
    #付け替え処理
    w[x] += w[U[x]]
    U[x] = k[0]
    #print(k)
    return (U[x],w[x])

def merge(a, b, U, r, w, w_add): #w_add　aにbを付け加える時、距離をwはなす
  a = find(a, U, r, w)[0]
  b = find(b, U, r, w)[0]
  if a == b:#何もしない
    return  
  """
  if r[a] < r[b]:
    a, b = b, a #a（深い）にb（浅い）をくっつける
  U[b] = a  
  if r[a] == r[b]:#もともと同じ深さの時だけ、結合後の深さが１増えるため
    r[a] += 1
  """
  U[b] = a
  r[a] = max(r[a], r[b]+1)
  w[b] += w_add
  return

N, M = map(int,input().split())
U = [i for i in range(N)]#前のノード（自分が先頭の時は自分の値）
w = [0 for _ in range(N)]#前のノードとの距離
r = [0 for _ in range(N)]#自分の木の深さ（自分が先頭の時のみ）

ans = True
for _ in range(M):
  
  L, R, D = map(int,input().split())
  L -= 1
  R -= 1
  t1 = find(L, U, r, w)
  t2 = find(R, U, r, w)
  #print(U,w)
  if t1[0] == t2[0] and not(t2[1] - t1[1] == D):
    ans = False 
    break
  if not(t1[0] == t2[0]):
    D -= t2[1] - t1[1]
    if r[L] < r[R]:
      L, R = R, L
      D = -D
    merge(L, R, U, r, w, D)
  
print("Yes" if ans else "No")