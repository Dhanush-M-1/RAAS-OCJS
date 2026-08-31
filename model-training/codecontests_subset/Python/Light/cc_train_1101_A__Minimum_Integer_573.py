nb_test = int(input())
for _ in range(nb_test):
    l, r, d = [int(x) for x in input().split()]
    if d < l:
        print(d)
    else:
        print((r//d + 1) * d)