n,k = map(int,input().split())
b = list(map(int,input().split()))
k = [k//b[i] for i in range(n) if k%b[i]==0]
print(min(k))