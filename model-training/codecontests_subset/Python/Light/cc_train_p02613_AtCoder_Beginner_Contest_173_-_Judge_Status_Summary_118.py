N = int(input())
s = list(input() for _ in range(N))
cntlst = ['AC', 'WA', 'TLE', 'RE']

for i in cntlst:
    print(i, 'x', s.count(i))