
def shovel(a,b,c):
    if a==0 and b==0 and c==0:
        return -1
    if a==0 and b==0:
        return 0
    if a==0 :
        print(1)
        return '%.5f'%(-c/b)
    if b==0:
        if c==0:
            print(1)
            return '%.5f'%(0)
    x=b*b-4*a*c
    if x<0:
        return 0
    if x==0:
        print(1)
        return '%.5f'%(-b/(2*a))
    y=(-b - (x ** 0.5)) / (2 * a)
    z=(-b+(x**0.5))/(2*a)
    print(2)
    if y<z:
        print('%.5f'%(y))
        return '%.5f'%(z)
    print('%.5f' % (z))
    return '%.5f' % (y)

a,b,c=map(int,input().split())
print(shovel(a,b,c))



