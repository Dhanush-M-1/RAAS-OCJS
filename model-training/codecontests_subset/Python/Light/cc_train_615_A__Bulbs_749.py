x, y = list(map(int, input().split()))
lista = []
ans = [0]*(y+1)
for i in range(x):
  lista.append(list(map(int, input().split())))

for i in range(x):
  for j in range(1, len(lista[i])):
    ans[lista[i][j]] += 1

print(["YES", "NO"][ans.count(0) > 1])