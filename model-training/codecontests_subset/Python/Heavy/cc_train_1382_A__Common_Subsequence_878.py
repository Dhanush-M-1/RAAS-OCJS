import sys

t = int(input())


def sub(list1, list2):
    inter = list1.intersection(list2)

    if not inter:
        print("NO")
        return
    else:
        print("YES")
        print(1, list(inter)[0])


i = 0
for line in sys.stdin:
    if i == 0:
        n, m = (int(x) for x in line.split())
    elif i == 1:
        list1 = [int(x) for x in line.split()]
        list1 = set(list1)
    elif i == 2:
        list2 = [int(x) for x in line.split()]
        list2 = set(list2)

        sub(list1, list2)

        i = -1
    i += 1
