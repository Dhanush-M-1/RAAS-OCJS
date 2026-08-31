t = int(input())
while t:
    n = int(input())
    if n == 1:
        print(0)
    else:
        cn = 0
        f = 0
        while n != 1:
            if n%6 != 0:
                if f == 1:
                    print(-1)
                    break
                else:
                    n *= 2
                    f = 1
                    cn += 1
                   
                
            elif n%6 == 0:
                n //= 6
                cn += 1
                f = 0
        else:
            print(cn)
    t -= 1
