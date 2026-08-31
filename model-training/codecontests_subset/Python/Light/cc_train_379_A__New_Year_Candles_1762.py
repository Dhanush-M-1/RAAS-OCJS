def n(x,y):
    if x<y :
        return x
    else :
        return (x//y)*y+n(x-(x//y)*(y-1),y)

x,y=[int(i) for i in input().split()]

print(n(x,y))
