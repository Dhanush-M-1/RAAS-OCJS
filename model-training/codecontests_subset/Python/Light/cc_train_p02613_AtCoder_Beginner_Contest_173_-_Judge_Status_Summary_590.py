n = int(input())
l = ['AC','WA','TLE','RE']
c = [input() for _ in range(n)]
for k in l:print(k,'x',c.count(k))