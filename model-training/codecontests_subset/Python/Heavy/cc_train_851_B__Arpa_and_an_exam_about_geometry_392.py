from sys import stdin, stdout
from decimal import Decimal
INF = Decimal('inf')
two = Decimal(2)
half = Decimal(0.5)



def angle_cos(a, b):
    return (a[0] * b[0] + a[1] * b[1]) / (((a[0] ** two + a[1] ** two) ** half) * ((b[0] ** two + b[1] ** two) ** half))


def angle_sin(a, b):
    return (a[0] * b[1] - a[1] * b[0]) / (((a[0] ** two + a[1] ** two) ** half) * ((b[0] ** two + b[1] ** two) ** half))    


def find_coordinates(x1, y1, x2, y2, x3, y3):
    A = x2 - x1
    B = y2 - y1
    C = x3 - x1
    D = y3 - y1
    E = A * (x1 + x2) + B * (y1 + y2)
    F = C * (x1 + x3) + D * (y1 + y3)
    G = 2 * (A * (y3 - y2) - B * (x3 - x2))
    if not G:
        return (INF, INF)

    x = (D * E - B * F) / G
    y = (A * F - C * E) / G 
    
    return (x, y)
    

x1, y1, x2, y2, x3, y3 = map(Decimal, stdin.readline().split())
x, y = find_coordinates(x1, y1, x2, y2, x3, y3)

first, second, third = (x1 - x, y1 - y), (x2 - x, y2 - y), (x3 - x, y3 - y)
if abs(x) != INF and angle_sin(first, second) == angle_sin(second, third) and angle_cos(first, second) == angle_cos(second, third):
    stdout.write('Yes')
else:
    stdout.write('No')