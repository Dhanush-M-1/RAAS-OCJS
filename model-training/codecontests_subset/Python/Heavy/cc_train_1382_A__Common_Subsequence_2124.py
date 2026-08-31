t = int(input())
for i in range(t):
    first = [int(s) for s in input().split(" ")]
    n = first[0]
    m = first[1]
    a = [int(s) for s in input().split(" ")]
    b = [int(s) for s in input().split(" ")]

    dct_a = {}
    for i in a:
        try:
            if dct_a[i] == 1:
                dct_a[i] += 1
        except KeyError:
            dct_a[i] = 1
    ok = 0
    for i in b:
        try:
            if dct_a[i] > 0:
                print("YES")
                print("1"+" "+str(i))
                ok = 1
                break
        except KeyError:
            dct_a[i] = -1
    if ok == 0:
        print("NO")


