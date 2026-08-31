di = {'AC':0, 'WA':0, 'TLE':0, 'RE':0}
n = int(input())
for _ in range(n):
    di[input()] += 1
[print(f"{key} x {val}") for key,val in di.items()]