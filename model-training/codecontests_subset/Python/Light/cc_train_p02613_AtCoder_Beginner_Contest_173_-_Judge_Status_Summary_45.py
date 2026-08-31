n = int(input())
x = ["AC", "WA", "TLE", "RE"]
y = [input() for _i in range(n)]
for i in x:
    print(i, 'x', y.count(i))