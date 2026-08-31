
L = []
L.append(list("abcde"))
L.append(list("fghij"))
L.append(list("klmno"))
L.append(list("pqrst"))
L.append(list("uvwxy"))
L.append(list("z.?! "))

while True:
    try:
        tmp = input()
        l = [int(x)-1 for x in list(tmp)]
    except:
        break
    if len(l) % 2 > 0:
        print("NA")
        continue

    ferr = 0
    M = []
    for i, j in zip(l[0::2],l[1::2]):
        if i not in range(len(L)) or j not in range(len(L[0])):
            ferr += 1
        else:
            M.append(L[i][j])
    if ferr > 0:
        print("NA")
    else:
        print("".join(M))


