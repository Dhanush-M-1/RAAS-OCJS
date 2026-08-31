r1,r2 = [int(x) for x in input("").split()]
c1,c2 = [int(x) for x in input("").split()]
d1,d2 = [int(x) for x in input("").split()]
for i in range(1, 9+1):
    for j in range(1, 9+1):
        for k in range(1, 9+1):
            for l in range(1, 9+1):
                if len(set([i,j,k,l])) != 4:
                    continue
                if i + j == r1 and k + l == r2 and i + k == c1 and j + l == c2 and i + l == d1 and j + k == d2:
                    print(i, j)
                    print(k, l)
                    exit()
print(-1)
