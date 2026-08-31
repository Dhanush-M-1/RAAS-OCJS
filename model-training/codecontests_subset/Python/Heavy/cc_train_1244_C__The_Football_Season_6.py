data = input()
data = data.split()
n = int(data[0])
p = int(data[1])
w = int(data[2])
d = int(data[3])

p_int_d = int(p/d)
p_rem_d = p%d
w_int_d = int(w/d)
w_rem_d = w%d

answer = False

if( (p/w) <= n):
    if( (p - n*d) <= 0 ) :
        low_lim = 0
    else :
        low_lim = int( (p - (n-1)*d)/w )
    top_lim = int(p/w)

    remain = False
    i = 0
    k = top_lim
    while (i < w):
        if (((p - w * k) % d) == 0):
            remain = True
            top_lim = k
            break
        i = i + 1
        k = k - 1

    g = 1
    while(i <= w) :
        if( ((i*w)%d) == 0 ):
            g = i
            break
        i = i + 1

    if(remain == True):
        i = top_lim
        while (i >= low_lim) :
            if( (i + int((p-i*w)/d)) <= n ) :
                if( ((p-w*i)%d) == 0 ):
                    answer = True
                    x = i
                    y =int((p-i*w)/d)
                    z = n - x - y
                    break
            else :
                break
            i = i - g

        if(answer == True) :
            print(x, end=' ')
            print(y, end=' ')
            print(z)
        else :
            print(-1)
    else :
        print(-1)
else :
    print(-1)
