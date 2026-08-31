a, b = map(int, input().split())
days = 0
while a-b >= 0:
    a = a-b+1
    days = days + b

print(days + a)
