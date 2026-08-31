n = int(input())
S = list(input() for _ in range(n))

for i in ['AC', 'WA', 'TLE', 'RE']:
    print(i + ' x ' + str(S.count(i)))