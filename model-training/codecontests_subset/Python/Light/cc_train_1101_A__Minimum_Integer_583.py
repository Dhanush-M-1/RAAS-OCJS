n = int(input())
for i in range(n):
    l,r,d = map(int,(input().split()))
    t = (r+1)%d
    if d<l:
        print(d)
    
    else:
        if t==0:
            print(r+1)
        else:
            print(r+1+d-t)

