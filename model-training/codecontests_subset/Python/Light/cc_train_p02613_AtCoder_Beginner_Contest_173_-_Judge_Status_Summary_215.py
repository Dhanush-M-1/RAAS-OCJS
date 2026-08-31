N = int(input())
D = {"AC":0, "WA":0, "TLE":0, "RE":0}

for _ in range(N):
  S = input()
  D[S] += 1

for i, x in D.items():
  print(i+" x "+str(x))