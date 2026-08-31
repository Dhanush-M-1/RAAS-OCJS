n,maxx,a,s = input().split()
w = [0,0,0]
e = 0
n = int(n)
maxx = int(maxx)
a = int(a)
s = int(s)

w[0] = maxx // a
e = w[0] * a

w[1] = (maxx - e) // s
e += w[1] * s
#print(w[0],w[1],w[2])
for yu in range(s):
    if ((maxx - e) > 0):
        if((maxx - e)// a-s):
            z = s - (maxx - e)
            w[0] -= 1
            w[1] += 1
    e = w[0] * a
    e += w[1] * s
    w[1] += (maxx - e) // s
    e = w[0] * a
    e += w[1] * s
if w[0]<0 or w[1]<0:
    print(-1)
else:
    #print(w[0],w[1],w[2])
    if w[0]+w[1]<=n:
        w[2] = n - w[0] - w[1]
        if e == maxx:
            print(w[0],w[1],w[2])
        else:
            print(-1)
    else:
        print(-1)

