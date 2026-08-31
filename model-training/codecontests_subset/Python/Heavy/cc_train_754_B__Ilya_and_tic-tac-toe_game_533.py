t = [input() for _ in range(4)]
w = ["xx.", ".xx", "x.x"]
if any(i in j for i in w for j in t):
  print("YES")
else:
  for p in range(4):
    c = "".join([r[p] for r in t])
    if any(i in c for i in w):
      print("YES")
      break
  else:
    d = [t[0][0]+t[1][1]+t[2][2]+t[3][3], t[1][0]+t[2][1]+t[3][2], t[0][1]+t[1][2]+t[2][3], t[3][0]+t[2][1]+t[1][2]+t[0][3], t[2][0]+t[1][1]+t[0][2], t[3][1]+t[2][2]+t[1][3]]
    if any(i in j for i in w for j in d):
      print("YES")
    else:
      print("NO")
    