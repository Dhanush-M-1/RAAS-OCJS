N = int(input())
S = {"AC":0,"WA":0,"TLE":0,"RE":0}
for _ in range(N):
    s = input()
    S[s] += 1
for k,v in S.items():
    print(k+" x "+str(v))