N = int(input())
S = [input() for _ in range(N)]

for j in ['AC', 'WA', 'TLE', 'RE']:
	print(f'{j} x {S.count(j)}')