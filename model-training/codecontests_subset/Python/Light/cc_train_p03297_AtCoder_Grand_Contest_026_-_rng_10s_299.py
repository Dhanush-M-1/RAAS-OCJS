def gcd(a,b):
    if b== 0:
        return a
    else:
        return gcd(b,a%b)

t = int(input())
abcd = []
ans = "No"
for i in range(0,t):
    ABCD = list(map(int,input().split()))
    abcd.append(ABCD)
for a,b,c,d in abcd:
    if a >= b and b==d and b <= c:
        ans = "Yes"
    if a >= b and d >= b and b > c and b - gcd(d,b) + a%gcd(d,b) <= c:
        ans = "Yes"
    if a >= b and d >= b and b <= c:
        ans = "Yes"
    print(ans)
    ans = "No"
