while True:
    try: ipt = input()
    except: break

    c = list(map(float, ipt.split(',')))
    x, y = c[::2], c[1::2]

    A_1 = (x[3]-x[1])*(y[2]-y[1]) - (y[3]-y[1])*(x[2]-x[1])
    A_2 = (x[0]-x[1])*(y[2]-y[1]) - (y[0]-y[1])*(x[2]-x[1])
    A = A_1 / A_2

    B_1 = (-(x[3]-x[1])*(y[0]-y[1])) + (y[3]-y[1])*(x[0]-x[1])
    B_2 = (x[0]-x[1])*(y[2]-y[1]) - (y[0]-y[1])*(x[2]-x[1])
    B = B_1 / B_2
    
    if A >= 0 and B >= 0 and A+B >= 1:
        print('YES')
    else:
        print('NO')

