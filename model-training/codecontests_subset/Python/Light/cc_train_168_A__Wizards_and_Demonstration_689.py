a = input().split()
n = int(a[0])
x = int(a[1])
y = int(a[2])
if (y * n / 100 <= x):
    print (0)
elif (y * n / 100 > x):
    if ((y * n / 100) > int(y * n / 100) and (y * n / 100) < (int(y * n / 100) + 1)):
        print (int(y * n / 100) + 1 - x)
    else:
        print (int (y * n / 100) - x)
