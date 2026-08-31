n = int(input())
s = [str(input()) for i in range(n)]
for h in ['AC','WA','TLE','RE']:
    print(h,'x',s.count(h))