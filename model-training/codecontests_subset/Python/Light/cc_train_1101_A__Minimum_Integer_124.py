import time
#input
n = int(input(""))
l = []
r = []
d = []
for i in range(n):
    a,b,c = input("").split()
    l.append(int(a))
    r.append(int(b))
    d.append(int(c))
#process
#output
for i in range(n):
    if(l[i]/d[i]>1):
        print(d[i])
    else:
        print((r[i]//d[i]+1)*d[i])
