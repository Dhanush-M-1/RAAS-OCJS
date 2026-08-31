a, b = map(int, input().split())
q = 0
while a > 0:
    a -= 1
    q += 1
    if q % b == 0:
        a += 1    
print(q)