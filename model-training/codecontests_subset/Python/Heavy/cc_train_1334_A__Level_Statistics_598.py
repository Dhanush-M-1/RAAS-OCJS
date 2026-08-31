test = int(input())
for t in range(test):
    level = int(input())
    origin = [0, 0]
    check = 1
    for l in range(level):
        next = [int(i) for i in input().split()]
        diff0 = next[0] - origin[0]
        diff1 = next[1] - origin[1]
        diff01 = next[0] - next[1]
        if check == 1 and diff0 < 0 or diff1 < 0 or diff01 < 0:
            check = 0
        elif check == 1 and diff0 < diff1:
            check = 0
        else:
            origin = next

        if l == level - 1:
            if check == 1:
                print("Yes")
            else:
                print("NO")