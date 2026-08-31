list_1 = list(input().split())
day = input()
print(*list_1, sep = " ")
for i in range(int(day)):
    dead , alive = input().split()
    if dead in list_1:
        list_1.remove(dead)
        list_1.append(alive)

    print(*list_1, sep = " ")
