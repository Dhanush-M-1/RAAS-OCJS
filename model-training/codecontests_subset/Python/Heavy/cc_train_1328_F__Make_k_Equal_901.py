# можно ли a привести к b
def check(a, b):
    answ = 0
    while 1:
        if a == b:
            return answ
        if a > b:
            answ += 1
            a //=2
        else:
            return -1

a = [int(i) for i in input().split()]
n = a[0]
k = a[1]
mas = [int(i) for i in input().split()]
steps = 10000000
for b in range(0, max(mas) + 1):
    buf = []
    for i in mas:
        tmp = check(i, b)
        if tmp >= 0:
            buf.append(tmp)
    
    if len(buf) >= k:
        buf.sort()
        Bsum = 0
        for i in range(k):
            Bsum += buf[i]
        if steps > Bsum:
            steps = Bsum
print(steps)
