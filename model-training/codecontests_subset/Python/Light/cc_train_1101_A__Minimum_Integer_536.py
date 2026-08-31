for i in int(input())*[0]:
    l=list(map(int,input().split()))
    if l[2]>=l[0]:
        z=l[2]*(0--l[1]//l[2])
        if z>l[1]:
            print(z)
        else:
            print(z+l[2])
    else:
        print(l[2])