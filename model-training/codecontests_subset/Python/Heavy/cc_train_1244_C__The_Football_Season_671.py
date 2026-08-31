n, p, w, d = list(map(int, input().split()))

#n, p, w, d = [random.randint(50, 100), random.randint(20, 40), random.randint(10, 20), random.randint(5, 10)]
#print(n, p, w, d)

rem = p % w
d_ = rem % d

#print(rem, d_)

n_ = (p - rem) + d_

n__ = n_ - d_

#print("n_ = ", n_)
#print("n__ = ", n__)

if rem > 0 and w%d == 0 and rem % d !=0:
    print(-1)
    exit(0)

i = 0
while True:
    if (n_ - i*d) < 0:
        print(-1)
        break
    if (n_ - i*d) % w == 0:
        #print("i = ", i)
        x = (n_ - i*d)//w
        y = rem//d + i
        z = n - ((n_ - i*d)//w + rem//d + i)
        if z >= 0:
            print(x, y, z)
        else:
            print(-1)
        break
    i += 1



'''
# print(rem)
if rem == 0:
    if (n - p//w) >= 0:
        print(int(p//w), 0, int(n - p//w))
    else:
        print(-1)
    exit(0)

if rem % d != 0:
    print(-1)
else:
    if n - p//w - rem//d >= 0:
        print(int(p//w), int(rem//d), int(n - p//w - rem//d))
    else:
        print(-1)
'''


