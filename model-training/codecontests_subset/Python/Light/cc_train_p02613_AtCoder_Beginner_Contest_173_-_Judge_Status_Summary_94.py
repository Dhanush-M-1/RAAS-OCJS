n = int(input())

ans = {'AC':0, 'WA':0, 'TLE':0, 'RE':0}

for i in range (n):
    ans[input()] += 1

for key in ans:
    print(key, 'x', ans[key])
