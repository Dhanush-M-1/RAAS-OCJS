t = int(input())
for i in range(t):
    N = int(input())
    pairs = []
    for j in range(N):
        x, y = map(int, input().split())
        pairs.append((x,y))
    c_x, c_y = 0,0
    no = 0
#    print(pairs)
    for pair in pairs:
        x, y = pair[0], pair[1]
        dif_p = x - c_x
        dif_c = y - c_y
#        print(dif_p)
#        print(dif_c)
        if (dif_p < dif_c) or (dif_p < 0) or (dif_c < 0):
            print("NO")
            no = 1
            break

        c_x = x
        c_y = y
    if not no:
        print("YES")


