n = int(input().strip())
a = list(int(i) for i in input().strip().split(' '))
e = []
o = []
for each in a:
    if each % 2 == 0:
        e.append(each)
    else:
        o.append(each)
e = sorted(e)
o = sorted(o)
e1 = [i for i in e]
o1 = [i for i in o]
s1=0
s2=0
if len(e) > 0 and len(o) > 0:
    if e[-1] > o[-1]:
        e.pop()
        p = 1
    else:
        o.pop()
        p = 0
    while(True):
        if p == 1 and len(o) > 0:
            o.pop()
            p = 0
        elif p == 0 and len(e) > 0:
            e.pop()
            p = 1
        else:
            break
    for i in e + o:
        s1 += i
    
    if len(e1) > len(o1):
        e1.pop()
        p = 1
    else:
        o1.pop()
        p = 0
    while(True):
        if p == 1 and len(o1) > 0:
            o1.pop()
            p = 0
        elif p == 0 and len(e1) > 0:
            e1.pop()
            p = 1
        else:
            break
    for i in e1 + o1:
        s2 += i
    print(min(s1,s2))
else:
    s=0
    if len(o) == 0:
        for i in range(len(e)-1):
            s +=e[i]
    else:
        for i in range(len(o)-1):
            s +=o[i]
    print(s)