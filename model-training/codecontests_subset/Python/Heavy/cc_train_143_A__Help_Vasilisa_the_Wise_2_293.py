r1, r2 = map(int, input().split(" "))
c1, c2 = map(int, input().split(" "))
d1, d2 = map(int, input().split(" "))
i,j,k,z=9,9,9,9
while(i>0):
    j=i-1
    while(j>0):
        k=j-1
        while(k>0):
            z=k-1
            while(z>0):
                q, w, r, e = i, j, k, z
                for _ in range(4):
                    for _ in range(3):
                        for _ in range(2):
                            if (q + w == r1 and w + e == c2 and e + r == r2 and r + q == c1 and q + e == d1 and w + r == d2 ):
                                print(q, w)
                                print(r, e)
                                exit()

                            r,e=e,r
                        w,r,e=r,e,w
                    q, w, r,e =w,r,e,q
                z-=1
            k-=1
        j-=1
    i-=1

print(-1)