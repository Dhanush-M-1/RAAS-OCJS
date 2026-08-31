t = int(input())
for i in range(t):
    empty = input()
    k, n, m = (int(i) for i in input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    s = ''
    mem = 0
    glf = True
    i = 0
    while i < n:
        if a[i] == 0:
            s += '0 '
            k += 1
        elif a[i] <= k:
            s += str(a[i]) + ' '
        elif mem != m:
            i -= 1
            flag = False
            for j in range(mem, m):
                if b[j] == 0:
                    s += '0 '
                    k += 1
                    mem += 1
                    break
                elif b[j] <= k:
                    s += str(b[j]) + ' '
                    mem += 1
                    break
                else:
                    flag = True
                    break
            if flag:
                glf = False
                print(-1)
                break
        else:
            glf = False
            print('-1')
            break
        i += 1
    if glf:
        for j in range(mem, m):
            if b[j] == 0:
                s += '0 '
                k += 1
            elif b[j] <= k:
                s += str(b[j]) + ' '
            else:
                glf = False
                print('-1')
                break
    if glf:
        print(s[:len(s) - 1])
