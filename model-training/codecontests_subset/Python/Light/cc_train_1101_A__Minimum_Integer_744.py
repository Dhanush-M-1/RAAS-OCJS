for t in range(int(input())):
    l,r,d=map(int,input().split(' '))
    x=l//d
    y=r//d
    if l%d==0:
        x=x-1
    if x>0:
        print(d)
    else:
        print((y+1)*d)

    
