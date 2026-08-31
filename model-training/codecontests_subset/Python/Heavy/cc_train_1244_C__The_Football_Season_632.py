x = 1
c = 1
y = 1

def ex_euclid(a,b):
    global x,y,c
    if b == 0:
        x = c;
        y = 0;
    else :
        ex_euclid(b,a%b);
        tem =x;
        x = y;
        y = tem - a//b*y;



def __gcd(a,b):
    if b == 0:
        return a
    return __gcd(b,a%b)

def main():
    n = input()
    n = n.split(" ")
    n = list(map(int, n))
    n,p,w,d = n

    _g = __gcd(w, d)
    if (p % _g != 0):
        print (-1)
        return ;
    global  x,y,c

    c = p // _g
    lcm = w*d // _g
    ex_euclid(w,d)

    val = (y * d) // lcm * lcm

    if y < 0:
        cnt = lcm // d
        cnt = (abs(y) - 1) // cnt + 1
        x -= lcm // w * cnt
        y += lcm // d * cnt
    else:
        x += val // w
        y -= val // d
    if x < 0 or y < 0 :
        print ("-1")
        return
    if (x + y > n) :
        print("-1")
        return

    print (x,y,(n-x-y))

if __name__ == '__main__':


    main()