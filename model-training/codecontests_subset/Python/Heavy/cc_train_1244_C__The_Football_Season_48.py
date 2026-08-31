import math
def main():
    noofgames,points,winpoints,drawpoints = map(int,input().split())
    common         = math.gcd(winpoints,drawpoints)
    if points == 0:
        print(0,0,noofgames)
        return
    if points%common:
        print(-1)
        return
    if common != 1 :
        points //= common
        winpoints //= common
        drawpoints //= common
    for i in range(winpoints):
        if drawpoints*i > points : 
            print(-1)
            return 
        a = (points - drawpoints*i)
        b = a%winpoints
        if a >= 0 and b == 0 :
            x = a//winpoints
            y = i
            z = noofgames - x - y 
            if z >= 0 :
                print(x,y,z)
                return
    print(-1)
    return
main()

