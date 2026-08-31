n=input()
n=int(n)
for i in range(0, n):
    l, r, d=input().split(' ')
    l, r, d=int(l), int(r), int(d)
    if d<l or d>r:
        print(d)
    else:
        k=r//d
        print((k+1)*d)
