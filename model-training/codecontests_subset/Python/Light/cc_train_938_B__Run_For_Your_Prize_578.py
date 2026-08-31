n = int(input())
a = list(map(int,input().split()))
mn = 10**6-a[0]
for i in range(1,len(a)):
    mn = min(mn, max(a[i-1]-1,10**6-a[i]))
mn = min(mn, a[len(a)-1]-1)
print(mn)
