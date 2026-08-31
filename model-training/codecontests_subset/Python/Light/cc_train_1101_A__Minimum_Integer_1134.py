a  = int(input())
for i in range(a):
    l,r,d = map(int, input().split())
    if(d<l):
        print(d)
    else:
        if(r%d == 0):
            print(r+d)
        else:
            p = int(r/d)
            print((p*d)+d)