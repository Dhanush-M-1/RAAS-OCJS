a, b = [int(i) for i in input().split()]

t = 0
burnt = 0

while a:
    a -= 1
    t += 1
    burnt += 1
    if burnt == b:
        burnt = 0
        a += 1

print(t)