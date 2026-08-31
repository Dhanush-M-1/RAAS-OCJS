r,r2 = [int(x) for x in input().split()]
c,c2 = [int(x) for x in input().split()]
d,d2 = [int(x) for x in input().split()]
res = []
for x in range(1,10):
    for y in range(1,10):
        for z in range(1,10):
            for k in range(1,10):
                if x!=y and x!=z and x!=k and y!=z and y!=k and k!=z and x+y==r and z+k==r2 and x+z==c and y+k==c2 and x+k==d and y+z==d2:
                    res = [x,y,z,k]
                    break
if res:
    print(res[0],res[1])
    print(res[2],res[3])
else:
    print(-1)