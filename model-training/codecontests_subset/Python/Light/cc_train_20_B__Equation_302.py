a, b, c = map(int, input().split())
if a == 0 and b == 0:
    print('0' if c else '-1')
elif a == 0:
    print('1', -c / b, sep='\n')
else:
    d, x = b ** 2 - 4 * a * c, 2 * a
    if d < 0:
        print('0')
    elif d == 0:
        print('1', -b / x, sep='\n')
    else:
        r = sorted(((-b + d ** 0.5) / x, (-b - d ** 0.5) / x))
        print('2', r[0], r[1], sep='\n')