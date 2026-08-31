a, b = map(int, input().strip().split())
tries = 0

if a == b:
    print(0)
    exit()

while True:
    if a % 2 == 0 and b % 2 == 0:
        a //= 2
        b //= 2
        continue
    if a % 3 == 0 and b % 3 == 0:
        b //= 3
        a //= 3
        continue
    if a % 5 == 0 and b % 5 == 0:
        b //= 5
        a //= 5
        continue
    else:
        break

while a != b:
    a, b = max(a, b), min(a, b)
    if a % 2 == 0:
        a //= 2
    elif a % 3 == 0:
        a //= 3
    elif a % 5 == 0:
        a //= 5
    else:
        tries = -1
        break
    tries += 1

print(tries)