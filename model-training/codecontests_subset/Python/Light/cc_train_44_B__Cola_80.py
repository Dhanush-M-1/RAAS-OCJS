def nik(rudy,pig,y,z):
    temp = 0
    for i in range(z+1):
        for j in range(y+1):
            t = rudy - i*2 -j
            if t>=0 and pig*0.5 >= t:
                temp+=1
    print(temp)
rudy, pig, y, z = list(map(int,input().split()))
nik(rudy,pig,y,z)
