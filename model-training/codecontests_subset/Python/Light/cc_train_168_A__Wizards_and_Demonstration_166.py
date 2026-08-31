ins=input().split()
n, x, y=int(ins[0]), int(ins[1]), int(ins[2])
l, r=0, 100000000000000
while l<r:
    c=(l+r)//2
    if ((c+x)/n)*100>=y: r=c
    else: l=c+1
print(l)


