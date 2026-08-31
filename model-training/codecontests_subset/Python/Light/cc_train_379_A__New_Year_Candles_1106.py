a, b = [int(x) for x in input().split(' ')]

t, r = 0, 0
while a:
    t += a
    n = (r + a) // b
    r = (r + a) % b
    a = n
    
print(t)