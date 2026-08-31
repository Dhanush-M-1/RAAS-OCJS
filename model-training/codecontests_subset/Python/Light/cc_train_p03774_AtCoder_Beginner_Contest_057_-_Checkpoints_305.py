N, M = map(int,input().split())
st = [[int(i) for i in input().split()] for j in range(N)]
cp = [[int(i) for i in input().split()] for j in range(M)]
for i in st:
    L = [abs(i[0] - j[0])+abs(i[1] - j[1]) for j in cp]
    m = min(L)
    print(L.index(m)+1)

