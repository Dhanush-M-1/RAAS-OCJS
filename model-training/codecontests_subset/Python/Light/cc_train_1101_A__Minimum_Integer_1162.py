q = int(input())
for i in range(0,q):
    l,r,d = map(int,input().split())
    if (d<l):
        print(d)
    elif (d>=l and d<=r):
        if (r%d == 0):
            print(r+d)
        else:
            print(r+(d-r%d))
    else:
        print(d)