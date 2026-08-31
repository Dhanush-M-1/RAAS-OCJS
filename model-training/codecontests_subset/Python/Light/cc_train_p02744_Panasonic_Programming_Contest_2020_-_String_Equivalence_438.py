k = int(input())
anss = [["a"]]

for i in range(k-1):
  anss.append([])
  for j in anss[i]:
    for l in range(len(set(list(j)))+1):
      anss[i+1].append(str(j)+chr(97+l))
anss[k-1].sort()
for i in anss[k-1]:
  print(i)