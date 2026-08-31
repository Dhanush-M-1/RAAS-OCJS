N=int(input())
C = {"AC":0,"WA":0,"TLE":0,"RE":0}
for i in range(N):
  C[input()] += 1
for s,c in C.items():
  print("{} x {}".format(s,c))