n,m = map(int, input().split())
stu = [list(map(int, input().split())) for _ in range(n)]
p = [list(map(int, input().split())) for _ in range(m)]

for x, y in stu:
    k = []
    for c, d in p:
        k.append(abs(x-c)+abs(y-d))
    print(k.index(min(k))+1)
        

