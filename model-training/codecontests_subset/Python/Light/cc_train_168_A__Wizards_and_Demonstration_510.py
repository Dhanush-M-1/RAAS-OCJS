def f(l):
    n,x,y = l
    return max((n*y+99)//100-x,0)

l   = list(map(int,input().split()))
print(f(l))

