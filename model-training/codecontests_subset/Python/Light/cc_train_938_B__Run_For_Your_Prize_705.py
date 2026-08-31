n=int(input())
l=list(map(int,input().split()))
m=0
for i in range(n):
    m=max(m,min(l[i]-1,10**6-l[i]))
print(m)