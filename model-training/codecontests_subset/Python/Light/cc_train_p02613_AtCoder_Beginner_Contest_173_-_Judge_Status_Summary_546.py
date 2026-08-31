N = int(input())
arr = [input() for i in range(N)]

for t in ['AC', 'WA', 'TLE', 'RE']:
    print(f'{t} x {arr.count(t)}')