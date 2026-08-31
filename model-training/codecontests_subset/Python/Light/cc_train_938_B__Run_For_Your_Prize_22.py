n=int(input())
a=[0]+list(map(int,input().split()))+[10**6]
m=10**6+1
for i in range(n+1):
    m=min(m,max(a[i]-1,10**6-a[i+1]))
print(m)
