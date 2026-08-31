N=int(input())
S=['AC','WA','TLE','RE']

TC=[]
for i in range(N):
    TC.append(input())

for s in S:
    print("{} x {}".format(s,TC.count(s)))