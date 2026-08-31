p1,p2 = input().split()
print(p1,p2)
tmp={1:p1,2:p2}
for i in range(int(input())):
    m,r = input().split()
    if tmp[1]==m:
        tmp[1]=r
        print(tmp[1],tmp[2])
    else:
        tmp[2]=r
        print(tmp[1],tmp[2])
