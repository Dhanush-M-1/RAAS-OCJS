def nik(n,rud):
    print(1,2,n)if (rud[0]+rud[1] <= rud[-1]) else print(-1)
for _ in range(int(input())):
    n = int(input())
    rud = list(map(int,input().split()))
    nik(n,rud)