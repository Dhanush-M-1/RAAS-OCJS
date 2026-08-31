from math import sin,radians
def C2(n):
    interiorangle = 360/(2*n)
    side = sin(radians(45))
    angle = 45
    number = (n-1)/2
    for i in range(int(number)):
        angle += interiorangle
        if angle > 90:
            angle = 180 - angle
            side += sin(radians(angle))
            angle = 180 - angle
        else:
            side += sin(radians(angle))
    angle = 45
    for i in range(int(number)):
        angle -= interiorangle
        if angle < 0:
            angle = -1 * angle
            side += sin(radians(angle))
            angle = -1 * angle
        else:
            side += sin(radians(angle))

    print(float(side))

a = int(input())
for _ in range(a):
    x = int(input())
    C2(x)