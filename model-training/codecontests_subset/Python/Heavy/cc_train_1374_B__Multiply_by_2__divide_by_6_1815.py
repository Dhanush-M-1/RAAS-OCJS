t = int(input())
l = []
for i in range(t):
    l.append(int(input()))
for i in range(t):
    n = 0
    if l[i] == 1:
        print(0)
    elif l[i] % 3 != 0:
        print(-1)
    else:
        while True:
            if l[i] % 6 == 0:
                l[i] /= 6
                n += 1
            if l[i] % 6 != 0  and l[i] % 3 == 0:
                l[i] *= 2
                n += 1
            if l[i] == 1:
                print(n)
                break
            if l[i] % 3 != 0:
                print(-1)
                break
                

