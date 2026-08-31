I=lambda:map(int,input().split())
for i in range(int(input())):
    l,r,d=I()
    if d<l or d>r :
        print(d)
    else:
        print((r//d)*d+d)