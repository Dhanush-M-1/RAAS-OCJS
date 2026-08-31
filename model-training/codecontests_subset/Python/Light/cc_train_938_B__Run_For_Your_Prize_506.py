n=int(input())
a=list(map(int,input().split()))
E=0
for i in range(n):
    E=max(E,min(a[i]-1,1000000-a[i]))
print(E)