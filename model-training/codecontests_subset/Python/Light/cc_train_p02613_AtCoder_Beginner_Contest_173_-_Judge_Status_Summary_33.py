N = int(input())
s = [input() for i in range(N)]

for v in ['AC', 'WA', 'TLE', 'RE']:
    print(f"{v} x {s.count(v)}")