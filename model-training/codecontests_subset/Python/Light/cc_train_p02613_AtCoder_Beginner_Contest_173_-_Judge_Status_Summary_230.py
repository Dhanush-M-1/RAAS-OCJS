n = int(input())
s = {'AC': 0, 'WA':0, 'TLE':0, 'RE':0}
for i in range(n):
    s[str(input())] += 1

for i in s:
    print(i+' x '+str(s[i]))
