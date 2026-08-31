n=int(input())
a=list(map(int,input().split()))
a.sort()
d=[]
for i in range(n):
    d.append(min(a[i]-1,1000000-a[i]))
print(max(d))