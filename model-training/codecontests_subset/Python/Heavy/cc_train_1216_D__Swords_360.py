def find_gcd(x, y):
    while (y):
        x, y = y, x % y

    return x


n = int(input())
l = list(map(int, input().rstrip().split(" ")))
l.sort()
c = 1
for i in range(n-2,-1,-1):
    if l[i]==l[-1]:
        c+=1
    else:
        break
if n-c<=1:
    print(1, l[-1]-l[0])
else:
    num1 = l[-1] - l[0]
    num2 = l[-1] - l[1]
    gcd = find_gcd(num1, num2)
    t = num1 + num2
    for i in range(2, n-c):
        t+= l[-1] - l[i]
        gcd = find_gcd(gcd, l[-1] - l[i])
    print(t//gcd, gcd)


