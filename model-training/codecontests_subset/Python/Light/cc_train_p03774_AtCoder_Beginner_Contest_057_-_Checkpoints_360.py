N,M=map(int,input().split())
AB=[list(map(int,input().split())) for i in range(N)]
CD=[list(map(int,input().split())) for i in range(M)]

for a,b in AB:
    x=10**20
    for i,(c,d) in enumerate(CD):
        l=int(abs(a-c)+abs(b-d))
        if x>l:
            x=l
            num=i+1
    print(num)
