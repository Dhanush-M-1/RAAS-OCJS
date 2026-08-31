n,k = input().split()
a = [int(x) for x in input().split()][:int(n)]
k = int(k)
maxi = 0
for x in a:
    if k%x == 0:
        if x > maxi:
            maxi = x
print(k//maxi)