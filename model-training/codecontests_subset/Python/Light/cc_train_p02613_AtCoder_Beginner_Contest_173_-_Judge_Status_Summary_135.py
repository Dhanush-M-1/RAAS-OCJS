N = int(input())
S = [input() for x in range(N)]
anser = ["AC","WA","TLE","RE"]

for i in anser:
    x = S.count(i)
    print(i ," x " ,x)