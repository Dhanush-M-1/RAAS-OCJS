q=int(input())

for i in range(q):
    
    l, r, d=map(int, input().rstrip().split())
    
    if l<=d:
        x=r//d*(d)+d
        print(x)
    else:
        print(d)