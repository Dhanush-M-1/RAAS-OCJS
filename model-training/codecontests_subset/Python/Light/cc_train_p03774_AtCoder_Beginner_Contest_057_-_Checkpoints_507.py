N,M=map(int,input().split())
s=[list(map(int,input().split()))for _ in[0]*N]
c=[list(map(int,input().split()))for _ in[0]*M]
for x,y in s:
    d={k+1:abs(x-t[0])+abs(y-t[1])for k,t in enumerate(c)}
    print(min(d,key=d.get))