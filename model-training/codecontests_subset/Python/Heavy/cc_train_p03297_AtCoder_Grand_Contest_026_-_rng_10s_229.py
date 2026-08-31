import fractions
t = int(input())
al = []
for i in range(t):
    a,b,c,d = map(int,input().split())
    if b > d:
        al.append("No")
    else:
        if b > a:
            al.append("No")
        else:
            if b-1 <= c:
                al.append("Yes")
            else:
                if a % b > c:
                    al.append("No")
                else:
                    yo = d%b
                    now = a%b 
                    if yo == 0:
                        al.append("Yes")
                    else:
                        g = fractions.gcd(b,yo)
                        #print(g)
                        if c >= b-g+a%g:
                            al.append("Yes")
                        else:
                            al.append("No")
for i in al:
    print(i)