t = int(input())


def valid(p1, c1, p2, c2):
    if p1 >= c1 and p2 >= c2 and (0 <= (c2 - c1) <= (p2 - p1)):
        return True
    else:
        return False


for tc in range(t):

    numpeeks = int(input())

    peeks = []

    for k in range(numpeeks):

        p, c = map(int, input().split())
        peeks.append([p, c])

    no = False

    if numpeeks == 1:
        if peeks[0][0] >= peeks[0][1]:
            print("YES")
        else:
            print("NO")

        continue

    for p in range(1, numpeeks):
        if valid(peeks[p - 1][0], peeks[p - 1][1], peeks[p][0], peeks[p][1]) == True:
            continue
        else:
            no = True

    if no == True:
        print("NO")
    else:
        print("YES")


