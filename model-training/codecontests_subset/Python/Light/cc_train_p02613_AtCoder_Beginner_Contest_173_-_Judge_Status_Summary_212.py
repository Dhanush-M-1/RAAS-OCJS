n=int(input())
l=[input()for _ in range(n)]
for s in ['AC','WA','TLE','RE']:
    print(s,'x',l.count(s))
