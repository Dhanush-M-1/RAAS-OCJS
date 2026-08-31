n,k = list(map(int,input().split()))
a = list(map(int,input().split()))
a = list(reversed(sorted(a)))
for i in range(n):
    if k%a[i] == 0:
        print(k//a[i])
        break
