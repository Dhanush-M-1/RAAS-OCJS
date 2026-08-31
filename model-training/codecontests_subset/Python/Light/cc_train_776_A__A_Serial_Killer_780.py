a,b = input().split()
n=int(input())
print(a,b)
for i in range(n):
    k,l = input().split()
    if k==a: a=l
    else: b=l
    print(a,b)