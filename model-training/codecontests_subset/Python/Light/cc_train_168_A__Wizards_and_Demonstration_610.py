import math

data = input().split()

N, X, Y = int(data[0]), int(data[1]), int(data[2])

clones = math.ceil(N * (Y/100)) - X

if clones > 0:
    print(clones)
else:
    print(0)
