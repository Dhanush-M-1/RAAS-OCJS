t = int(input())
while t != 0:
    n = int(input())
    txt = input()
    v = txt.split(" ")

    if int(v[0]) + int(v[1]) <= int(v[n - 1]):
        print(1, 2, n)
    else:
        print(-1)
    t -= 1