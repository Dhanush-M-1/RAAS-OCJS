q=int(input())
for i in range(q):
    l,r,d=map(int, input().split())
    g=r//d+1
    if d<l:
        print(d)
    else:
        print(g*d)
    
    