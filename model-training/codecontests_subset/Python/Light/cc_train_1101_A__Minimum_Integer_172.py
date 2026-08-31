def min_numb(lst):
    a = list()
    for elem in lst:
        if elem[2] < elem[0] or elem[2] > elem[1]:
            a.append(elem[2])
        else:
            a.append((elem[1] // elem[2]) * elem[2] + elem[2])
    return a


q = int(input())
b = list()
for i in range(q):
    l, r, d = [int(j) for j in input().split()]
    b.append([l, r, d])
for x in min_numb(b):
    print(x)
