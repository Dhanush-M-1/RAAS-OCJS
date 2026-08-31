nb = int(input())
liste = []
roger = True
for loop in range(nb):
    l,r,d = map(int,input().split())
    if d<l or d>r:
        print(d)
    else:
        print((r//d)*d + d)
        