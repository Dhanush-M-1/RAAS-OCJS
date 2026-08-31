t = int(input())
for _ in range(t):
    x = ['.'] + list(input()) + ['.'] + ['.']
    change = 0
    for i in range(2, len(x)-2):
        if x[i] == x[i-1] or x[i] == x[i-2]:
            for j in range(0, 26):
                k = j + ord('a')
                if k != ord(x[i]):
                    if k != ord(x[i-1]):
                        if k != ord(x[i-2]):
                            if k != ord(x[i+1]):
                                if k != ord(x[i+2]):
                                    x[i] = chr(k)
                                    change += 1
                                    break
    print(change)
