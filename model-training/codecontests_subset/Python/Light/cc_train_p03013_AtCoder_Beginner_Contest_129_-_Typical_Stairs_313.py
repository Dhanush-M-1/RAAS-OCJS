N,M=map(int,input().split())
A=[int(input()) for n in range(M)]
S=[1]*(N+1)
for a in A:
  S[a]=0
for i in range(2,N+1):
  S[i]=(S[i-1]+S[i-2])%1000000007*S[i]

print(S[-1])