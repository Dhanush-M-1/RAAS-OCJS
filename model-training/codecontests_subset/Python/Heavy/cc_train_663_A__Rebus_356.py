a = list(input().split())
n = int(a[-1])
R = int(a[-1])
one, two = 0, 0
for i in range(1,len(a),2):
    if a[i] == '=':
        break
    if a[i] == '+':
        R -= 1
        one += 1
    else:
        R += 1
        two += 1
R -= 1
one += 1
if R >= 0:
    if one * (n - 1) >= R:
        print('Possible')
        for i in range(0, len(a), 2):
            if i > 0 and a[i - 1] == '=':
                print(a[i])
            else:
                if i == 0 or a[i - 1] == '+':
                    print(min(n - 1, R) + 1, a[i + 1], end = ' ')
                    R -= min(n - 1, R)
                else:
                    print(1, a[i + 1], end = ' ')
    else:
        print('Impossible')
else:
    if two * (1 - n) <= R:
        print('Possible')
        for i in range(0, len(a), 2):
            if i > 0 and a[i - 1] == '=':
                print(a[i])
            else:
                if i > 0 and a[i - 1] == '-':
                    print(-(max(1 - n, R) - 1), a[i + 1], end = ' ')
                    R -= max(1 - n, R)
                else:
                    print(1, a[i + 1], end = ' ')
                    
    else:
        print('Impossible')
    
