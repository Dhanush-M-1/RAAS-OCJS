def getbit(n,k):
    return (n & (1 <<k)) >> k
x = int(input())
a = []
for i in range(2,int(x ** 0.5) + 2):
    if x % i == 0:
        c = 0
        while x % i == 0:
            x //= i
            c += 1
        a.append(i ** c)
if x != 1:
    a.append(x)
ans = [21674627468627481,0]
for mask in range(1 << len(a)):
    n1 = 1
    n2 = 1
    for i in range(len(a)):
        if getbit(mask, i):
            n1 *= a[i]
        else:
            n2 *= a[i]
    if max(ans) > max(n1,n2):
        ans = [n1,n2]
print(*ans)
