import math
nxy = list(map(int, input().split()))
n = nxy[0]
x = nxy[1]
y = nxy[2]
indemo = math.ceil((y / 100) * n)
clones = 0
if indemo - x > 0:
    clones = indemo - x
print(clones)
