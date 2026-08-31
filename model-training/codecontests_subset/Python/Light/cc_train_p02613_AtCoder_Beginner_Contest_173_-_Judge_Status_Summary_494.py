N = int(input())
S = [input() for _ in range(N)]

for a in ['AC','WA','TLE','RE']:
    print(a, 'x', S.count(a))