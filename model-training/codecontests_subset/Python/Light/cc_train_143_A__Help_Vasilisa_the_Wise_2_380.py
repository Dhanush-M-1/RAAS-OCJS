r1,r2 = map(int,input().split())
c1,c2 = map(int,input().split())
d1,d2 = map(int,input().split())
res = [[-1]]
for i in range(1,10):
    for j in range(1,10):
        for k in range(1,10):
            for l in range(1,10):
                if i + j == r1 and i + k == c1 and i +l == d1 and j +l == c2 and k +l == r2 and j+k == d2 :
                    if len(set([i,j,k,l])) == 4:
                        res = [[i,j],[k,l]]
[print(*i) for i in res]