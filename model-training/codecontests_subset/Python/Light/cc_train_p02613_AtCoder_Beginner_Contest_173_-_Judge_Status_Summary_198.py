N = int(input())
D = {"AC":0, "WA":0, "TLE":0, "RE":0}
for i in range(N):
    D[input()] += 1
for k,v in D.items():
    print(k + " x " + str(v))