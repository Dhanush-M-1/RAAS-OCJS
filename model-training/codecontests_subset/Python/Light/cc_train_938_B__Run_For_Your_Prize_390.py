n = int(input())
a = list(map(int,input().split()))
b = []
p = 10**6
for i in range(n):
    b.append(min(a[i]-1,p-a[i]))
print(max(b))
