mp = {'AC': 0,'WA': 0,'TLE': 0, 'RE': 0}
for _ in range(int(input())): mp[input()] += 1
for i, k in mp.items():
    print(i, 'x', k)