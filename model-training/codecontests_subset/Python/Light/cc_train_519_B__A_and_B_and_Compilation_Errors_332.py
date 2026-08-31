amount = input()

lists = []
for x in range(3):
    newList = list(map(int, input().split()))
    newList.sort()
    lists.append(newList)


def diff(a, b):
    items = []
    lengthA = len(a)
    lengthB = len(b)

    i = 0
    j = 0

    while j < lengthA:
        if lengthB <= j or a[i] != b[i]:
            items.append(a[j])
            j += 1

        i += 1
        j += 1

    return items

print(diff(lists[0], lists[1])[0])
print(diff(lists[1], lists[2])[0])