n = int(input())
rIn = lambda: map(int,input().split())
if n <= 2:
    print (n)
else:

    m,hm=rIn()
    r,hr = rIn()
    total = 2
    for i in range(n-2):
        l = m
        m,hm = r,hr
        r,hr = rIn()
        if m-hm > l: total+=1
        elif m+hm<r:
            total+=1
            m=m+hm
    print (total)

