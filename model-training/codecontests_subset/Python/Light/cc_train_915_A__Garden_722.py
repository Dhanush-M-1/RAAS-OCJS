n,m = map(int,input().split())
a = list(map(int,input().split()))
b = []
for i in range(len(a)):
    if m % a[i] == 0:
        b.append(a[i])
print(int(m/max(b)))