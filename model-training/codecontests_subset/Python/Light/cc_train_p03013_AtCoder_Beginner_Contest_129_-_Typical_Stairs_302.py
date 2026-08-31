N,M=map(int,input().split())
A={int(input()) for _ in [0]*M}
D=[1,0 if 1 in A else 1]
for i in range(2,N+1):
  D += [0] if i in A else [(D[-1]+D[-2])%1000000007]
print(D[N])