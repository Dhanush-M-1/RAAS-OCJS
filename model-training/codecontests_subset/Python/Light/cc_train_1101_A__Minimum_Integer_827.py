q = int ( input () )
for i in range (q):
    l,r,d = map( int,input().split())
    if d < min(l,r):
        print(d)
    else:
        print((max(l,r)+d)//d*d)
