def diff(list1, list2):
    for i in range(len(list2)):
        if (list1[i] != list2[i]):
            return list1[i]
    return list1[-1]
input()
def read():
    a = [int(i) for i in input().split()]
    a.sort()
    return a
l1 = read()
l2 = read()
l3 = read()
print(diff(l1, l2))
print(diff(l2, l3))
