from math import sqrt

a,b,c = map(int,input().split())

if a==0 and b == 0:
    if c == 0:
        print("-1")
    else:
        print("0")

elif a == 0 :
    if c == 0:
        print(1)
        print("{:.5f}".format(c))
    else:
        x = -1*c/b
        print('1')
        print ("{:.5f}".format(x))
elif b == 0 :
    if c == 0:
        print(1)
        print("{:.5f}".format(c))
    else:
        x = -1*c/a
        if x<0:
            print('0')
        else:
            print('1')
            print ("{:.5f}".format(x))

else:
    result = b**2 - 4*a*c
    if result<0:
        print('0')

    else:
        x = ((-1*b) - sqrt(result))/(2*a)
        y = ((-1*b) + sqrt(result))/(2*a)

        if x == y:
            print(1)
            print("{:.5f}".format(x))
        else:

            print(2)
            if x<y:
                print("{:.5f}".format(x))
                print("{:.5f}".format(y))
            else:
                print("{:.5f}".format(y))
                print("{:.5f}".format(x))























        
