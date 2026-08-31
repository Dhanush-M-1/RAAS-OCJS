t=int(input())
for i in range(t):
    l,r,d=list(map(int,input().strip().split()))
    if l>d:
        print(d)
    else:
        print(d*(r//d+1))
        