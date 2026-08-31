while True:
    n = int(input())
    if n == 0:
        break

    step = list(input().split())
    l = r = 0
    ne = 1
    cnt = 0
    for mov in step:
        if mov == "lu":
            l = 1
        elif mov == "ru":
            r = 1
        elif mov == "ld":
            l = 0
        else:
            r = 0
        if l == r == ne:
            cnt += 1
            ne = (ne + 1) % 2
    print(cnt)
