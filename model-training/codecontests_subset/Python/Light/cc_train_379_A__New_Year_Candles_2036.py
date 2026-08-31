a, b = map(int, input().split())
sm = a

while a >= b:
    sm += a // b
    a = a // b + a % b

print(sm)
