n,k = (int(x) for x in input().strip().split())
mn = 10000
for x in input().strip().split():
        a = int(x)
        if k%a==0:
            mn = min(k/a,mn)

print(int(mn))