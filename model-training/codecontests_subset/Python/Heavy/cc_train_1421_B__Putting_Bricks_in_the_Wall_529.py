for _ in " "*int(input()):
    a=int(input())
    z=[[0]*(a+1)]
    for i in range(a):
        f=[0]+list(map(str,input().replace('',' ').split()))
        z.append(f)
    k=z[1][2]
    k1=z[2][1]
    k2=z[a-1][a]
    k3=z[a][a-1]
    o=[k,k1,k2,k3]
    z,z1=0,0
    for i in o:
        if i=='0':z+=1
        else:z1+=1
    if z==z1:
        if k==k1:print(0)
        else:
            print(2)
            if k=='0':print(1,2)
            else:print(2,1)
            if k2=='1':print(a-1,a)
            else:print(a,a-1)
    elif z==3 or z1==3:
        print(1)
        if k==k1:
            if k2==k:print(a-1,a)
            else:print(a,a-1)
        else:
            if k2==k:print(1,2)
            else:print(2,1)
    else:
        print(2)
        print(1,2)
        print(2,1)