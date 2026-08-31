n, k, q = map(int, input().split())
alist = list(map(int, input().split()))
ans = None
if q == 1:
  print(0)
else:
  for i, a in enumerate(alist):
    spla = []
    preva = -1
    ailist = alist[:i] + alist[i+1:]
    for j, _a in enumerate(ailist):
      if _a < a:
        spla.append(ailist[preva+1:j])
        preva = j
    if not preva == len(ailist)-1:
      spla.append(ailist[preva+1:])
    conda = []
    for sa in spla:
      if len(sa) >= k:
        conda.extend(list(sorted(sa))[:len(sa)-k+1])
    if len(conda) < q-1:
      continue
    else:
      y = list(sorted(conda))[q-2]
      if ans is None or ans > y - a:
        ans = y - a

  print(ans)
