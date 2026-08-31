l1 = [int(x) for x in input().split()]
n = l1[0]
p = l1[1]
w = l1[2]
d = l1[3]
if p//w>n:
    print(-1)
else:
    rem = p%w
    x = p//w
    y = 0
    b = 0
    matched = False
    if w%d==0 and rem%d!=0:
        print(-1)
    else:
        while True:
            val = (rem+b*w)
            if val%d==0:
                y = val//d
                matched = True
                break
            else:
                b+=1
                x-=1
            if x+b>n:
                break
        if matched==True:
            z = n-x-y
            if z>=0 and x>=0 and y>=0:
                print(x,y,z)
            else:
                print(-1)
        else:
            print(-1)