n = int(input())

def oo(x):
    return 0
def ob(x):
    if x%3==2:
        return 0
    else:
        return 1
def bo(x):
    if x%3==0:
        return 0
    else:
        return 1
def bb(x):
    if x%3==1:
        return 0
    else:
        return 1

for i in range(n):
    q = list(map(int,input().split()))
    a = bin(q[0])[2:]
    b = bin(q[1])[2:]
    x = q[2]-1
    l = []
    if len(a) > len(b):
        b = (len(a)-len(b))*'0' + b
    else:
        a = (len(b)-len(a))*'0' + a
    for i in range(len(a)):
        if a[i] == '1' and b[i] == '0':
            l.append(bo(x))
        elif a[i] == '0' and b[i] == '0':
            l.append(oo(x))
        elif a[i] == '0' and b[i] == '1':
            l.append(ob(x))
        else:
            l.append(bb(x))
    res =  "".join(map(str, l))
    print (int(res,2))