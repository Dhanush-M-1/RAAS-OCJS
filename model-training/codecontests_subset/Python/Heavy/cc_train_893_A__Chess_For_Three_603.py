n = int(input())
a = []
for i in range(n):
    a.append(int(input()))

spectator = 3
can = True
for winner in a:
    if winner == spectator:
        can = False

    if spectator == 1:
        if winner == 2:
            spectator = 3
        else:
            spectator = 2
    elif spectator == 2:
        if winner == 1:
            spectator = 3
        else:
            spectator = 1
    else:
        if winner == 1:
            spectator = 2
        else:
            spectator = 1

if can:
    print("YES")
else:
    print("NO")