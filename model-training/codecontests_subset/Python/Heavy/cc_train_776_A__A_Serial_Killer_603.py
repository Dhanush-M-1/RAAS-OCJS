start = input()
n = int(input())

d = []
for i in range(n):
    r = input()
    d.append(r)
#print(d)

z = start
m = [z]
for i in range(n) :
    y = m[i]
    for u in range(len(y)):
        if y[u] == " " :
            a = u
    # print(z)
    b = y[:a]
    c = y[a + 1:]
    # print(b)
    # print(c)

    e = d[i]
    for j in range(len(e)):
        if e[j] == " " :
            f = j
    g = e[:f]
    h = e[f+1:]
    #print(g)
    #print(h)
    if b == g :
        k = h + " " + c
        m.append(k)
        #z = k
#        print(z)
    elif c == g :
        l = b + " " + h
        m.append(l)
        #z = l
#        print(z)
#print(z)
#print(start)
for q in range(len(m)):
    print(m[q])
