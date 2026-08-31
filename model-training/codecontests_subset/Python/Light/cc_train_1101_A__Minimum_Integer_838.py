N = int(input())
for i in range(N):
    l,r,d = [int(u) for u in input().split()]
    if(l*1.0/d>1):
        print(d)
    else:
        print(d*(r//d)+d)
