def prime(x):
    a=[]
    b=1
    while b <= (x-1)//2:
        if x-(x//(2*b + 1))*(2*b + 1) == 0:
            a.append(2*b + 1)
            x = x//(2*b + 1)
            b = 1
            continue
        else:
            b += 1
    return a


def sol():
    n = int(input())
    if n==1:
        print(1)
    if n==2:
        print(2)
    if n!=1 and n!=2:
        if n -(n//2)*2 != 0:
            print(n*(n-1)*(n-2))
        else:
            k=1
            while 3 <= 2*k +1 <= (n+2)//2:
                g = 0
                f = 0
                for x in prime(2*k+1):
                    if n-(n//x)*x == 0:
                        g = 1
                        break
                if g == 1:
                    k += 1
                    continue
                for x in prime(2*k):
                    if (n - 1) - ((n -1) // x)*x == 0:
                        f = 1
                        break
                if f == 1:
                    k += 1
                    continue
                print(max((n-1)*(n-2)*(n-3),n*(n-1)*(n-2*k-1)))
                break
            if f==1 or g==1:
                print(max((n-1)*(n-2)*(n-3),n*(n-1)*(n-2)//2))


sol()
