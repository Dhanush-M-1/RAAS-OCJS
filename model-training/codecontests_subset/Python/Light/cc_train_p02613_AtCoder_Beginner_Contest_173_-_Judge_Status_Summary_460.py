judges = ['AC', 'WA', 'TLE', 'RE']
n =  int(input())
S = [input() for _ in range(n)]
for j in judges:
    print(f'{j} x {S.count(j)}')