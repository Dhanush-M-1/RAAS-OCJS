n,k = map(int,input().split())
a = list(map(int,input().split()))
l = []
for i in range(len(a)):
    if k % a[i] == 0 :
        l.append(k//a[i])
print(min(l))
