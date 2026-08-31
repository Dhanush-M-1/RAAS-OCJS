N,M=map(int, input().split())
A=set(int(input()) for _ in range(M))
D=[0]*(N+1)
D[0]=1

for i in range(1,N+1):
 if i in A: continue
 D[i]=(D[i-1]+D[i-2])%(10**9+7)
print(D[-1])