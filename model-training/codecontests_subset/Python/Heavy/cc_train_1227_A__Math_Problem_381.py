for i in range(int(input())):
    n = int (input())
    l_1, r_1 = map(int, input().split())
    necess = ["-", l_1, r_1]
    for j in range(n - 1):
        l, r = map(int, input().split())
        if necess[0] == "-" and necess[1] <= r <= necess[2] and necess[1] <= l <= necess[2]:
            necess[1] = l
            necess[2] = r
        elif necess[0] == "-" and necess[1] <= r <= necess[2]:
            necess[2] = r
        elif necess[0] == "-" and necess[1] <= l <= necess[2]:
            necess[1] = l
        elif necess[0] == "-" and r < necess[1]:
            necess[0] = "+"
            necess[2] = necess[1]
            necess[1] = r
        elif necess[0] == "-" and l > necess[2]:
            necess[0] = "+"
            necess[1] = necess[2]
            necess[2] = l
        elif necess[0] == "+" and r < necess[1]:
            necess[1] = r
        elif necess[0] == "+" and l > necess[2]:
            necess[2] = l
    if necess[0] == "-":
        print(0)
    else:
        print(necess[2] - necess[1])