n=int(input())
for i in range(n):
    l,r,d=map(int,input().split())
    if r>=d and d>l:
        print(d*(r//d+1))
    elif r>d and l>=d:
        if l==d:
            print(d*(r//d+1))
        else:
            print(d)
    elif r<d:
        print(d)
    elif r==l and l==d:
        print(d*2)