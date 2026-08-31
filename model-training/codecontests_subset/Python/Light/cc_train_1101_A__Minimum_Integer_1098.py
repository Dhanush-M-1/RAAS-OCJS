q=int(input())
for i in range(q):
    l,r,d=map(int,input().split())
    if l/d>1:
        print(d)
    else:
        print(int(r/d)*d+d)