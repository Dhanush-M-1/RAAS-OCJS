a, b = [int(x) for x in input().split()]

n_burnt = 0
counter = 0
while a > 0:
    counter += 1
    a -= 1
    n_burnt += 1
    if n_burnt == b:
        a += 1
        n_burnt = 0 

print(counter)