n = int(input())
cur = 1
# 1 = AB
# 2 = AC
# 3 = BC
can = True
for i in range(n):
    x = int(input())
    if x == 1:
        if cur == 3:
            can = False
        elif cur == 1:
            cur = 2
        elif cur == 2:
            cur = 1

    elif x == 2:
        if cur == 2:
            can = False
        elif cur == 1:
            cur = 3
        elif cur == 3:
            cur = 1

    elif x == 3:
        if cur == 1:
            can = False
        elif cur == 2:
            cur = 3
        elif cur == 3:
            cur = 2

print("YES" if can else "NO")