n = int(input())
if n>=2 and n<=30:
    home = []
    away = []
    check = 1

    for i in range(n):
        h, a = map(int, input().split())
        home.append(h)
        away.append(a)
        if check != 0:
            if h>=1 and h<=100 and a>=1 and a<=100:
                check = 1
            else:
                check = 0

    if check == 1:
        guestuniform = 0
        i = 0
        while i<n:
            j = 0
            while j<n:
                if j == i:
                    j += 1
                    continue
                else:
                    if home[i] == away[j]:
                        guestuniform += 1
                j += 1
            i += 1
        print(guestuniform)