def gcd(a, b): 
    if a == 0 :
        return b 
    return gcd(b%a, a)
for _ in range(int(input())):
    a,b,c,d=[int(x) for x in input().split()]
    if a<b:
        print("No")
        continue
    if d<b:
        print("No")
        continue
    if b<=c:
        print("Yes")
        continue
    g=gcd(b,d)
    if c>=b-g+a%g:
        print("Yes")
    else:
        print("No")