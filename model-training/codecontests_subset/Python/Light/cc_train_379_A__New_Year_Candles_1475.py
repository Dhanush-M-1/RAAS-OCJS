a, b = map(int, input().split())
total = a;count = 0
while(True):
    if b <= a and a >= b:
        total += (a//b)
        a = (a//b)+a % b
    else:
        break
print(total)
