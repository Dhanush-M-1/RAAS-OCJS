N = int(input())
S = [input() for i in range(N)]
Result = ['AC', 'WA', 'TLE', 'RE']

for i in Result:
    print(i, 'x', S.count(i))