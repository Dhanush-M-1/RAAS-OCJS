# cook your dish here
t = int(input())

for i in range(t):
    a,b,c = input().split(' ')
    a = int(a)
    b = int(b)
    c = int(c)
    ans = 0
    
    if b == 0:
        print("0")
    else:
        n = int(c/2)
        if n:
            if (b-n)>0:
                b -= n
                c -= 2*n
                ans += 3*n
            else:
                c = c-(2*b)
                ans += 3*b
                b = 0
        n = int(b/2)
        if n:
            if (a-n)>0:
                a -= n
                b -= 2*n
                ans += 3*n
            else:
                if a>0:
                    b = b-(2*a)
                    ans += 3*a
                    a = 0
                
        print(ans)