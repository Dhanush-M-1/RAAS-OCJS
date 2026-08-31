q = int(input())
for i in range(q):
    l,r,d = map(int,input().split())
    if l > d:
        print(d)
    else:
        print(((r//d)+1)*d)

