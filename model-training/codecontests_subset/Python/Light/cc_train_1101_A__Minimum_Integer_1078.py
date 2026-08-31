user_i = input()
q = int(user_i)

for i in range(q):
    user_i = input()
    l, r, d = user_i.split(' ')
    l = int(l)
    r = int(r)
    d = int(d)

    if d < l:
        print(d)
    else:
        print( int(r/d) * d + d)
