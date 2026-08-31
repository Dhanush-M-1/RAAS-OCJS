import math

a,b,c = [float(x) for x in input().split(' ')]
if a == 0:
    if b == 0:
        if c == 0: print(-1)
        else: print("%.10f" %0)
    else:
        print(1)
        print("%.10f" %(-c/b))
else:
    aux = b ** 2 - 4 * a * c
    if aux > 0:
        print(2)
        arr = [(-b + math.sqrt(aux))/(2 * a), (-b - math.sqrt(aux))/(2 * a)]
        arr.sort()
        print("%.10f" %arr[0])
        print("%.10f" %arr[1])
    elif aux == 0:
        print(1)
        print("%.10f" %(-b/(2 * a)))
    else:
        print("%.10f" %0)