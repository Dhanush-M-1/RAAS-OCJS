r1, r2 = list(map(int, input().split(" ")))
c1, c2 = list(map(int, input().split(" ")))
d1, d2 = list(map(int, input().split(" ")))
ans = [0]*4
for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):
            for l in range(1, 10):
                if d1 == i+l and c1 == i + k and c2 == j+l and d2 == j+k and r1 == i+j and r2 == k + l:
                    ans[0],ans[1],ans[2],ans[3]=i,j,k,l

if len(set(ans)) < 4:
    print(-1)
else:
    print(ans[0],end=" ")
    print(ans[1])
    print(ans[2],end=" ")
    print(ans[3])

