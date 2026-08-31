n, m = map(int, input().split())
ab = [list(map(int, input().split())) for _ in range(n)]
cd = [list(map(int, input().split())) for _ in range(m)]

def how_long(aabb, ccdd):
    return abs(aabb[0]-ccdd[0])+abs(aabb[1]-ccdd[1])

for stu in ab:
    r = [how_long(stu,cd[i]) for i in range(m)]
    print(r.index(min(r))+1)