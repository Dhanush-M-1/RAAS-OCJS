for i in range(int(input())):
    l, r, d = [int(x) for x in input().split()]
    print(d if d < l else r - (r % d) + d)