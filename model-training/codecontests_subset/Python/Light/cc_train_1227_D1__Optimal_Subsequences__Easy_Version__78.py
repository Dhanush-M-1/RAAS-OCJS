n = int(input())
a = [int(x) for x in input().split()]
m = int(input())
for i in range(m):
    kj, posj = map(int, input().split())
    a_copy = [x for x in a]
    for u in range(n - kj):
        mid = 0
        for uuu in range(len(a_copy)):
            if a_copy[uuu] <= a_copy[mid]:
                mid = uuu
        a_copy.pop(mid)
    print(a_copy[posj-1])