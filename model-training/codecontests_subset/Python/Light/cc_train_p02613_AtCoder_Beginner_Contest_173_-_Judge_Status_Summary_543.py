n = int(input())
a = [input() for _ in range(n)]
c = ['AC', 'WA', 'TLE', 'RE']
for i in c:
    print(i + " x " + str(a.count(i)))