n, m = list(map(int, input().split()))
# 生徒の場所
ab = [list(map(int, input().split())) for i in range(n)]
# チェックポイント
cd = [list(map(int, input().split())) for i in range(m)]

for val in ab:
  tmp = []
  for point in cd:
    tmp.append(abs(val[0]-point[0])+abs(val[1]-point[1]))
  print(tmp.index(min(tmp))+1)