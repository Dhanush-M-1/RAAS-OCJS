from fractions import gcd
n=int(input())
h=[]
for i in range(n):
    w=list(map(int,input().split()))
    h.append(w)
for i in range(n):
    a,b,c,d=h[i][0],h[i][1],h[i][2],h[i][3]
    if(b>a or b>d):
        print("No")
        continue
    if(b<=c):
        print("Yes")
        continue
    if(b-gcd(b,d)+a%gcd(b,d)<=c):print("Yes")
    else:print("No")
    continue