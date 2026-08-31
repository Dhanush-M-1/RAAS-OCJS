n = int(input())
l = {'AC':0, 'WA':0, 'TLE':0, 'RE':0}
for _ in range(n):l[input()] += 1
for k in l.keys():print(k+' x '+str(l[k]))