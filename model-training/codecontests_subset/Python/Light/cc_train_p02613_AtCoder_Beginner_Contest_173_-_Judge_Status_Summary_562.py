n = int(input())
di = {'AC':0, 'WA':0, 'TLE':0, 'RE':0}
for _ in range(n):
    di[input()] += 1
for i, j in di.items():
    print(i, 'x', j)
