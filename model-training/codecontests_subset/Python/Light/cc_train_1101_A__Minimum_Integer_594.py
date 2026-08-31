def cin():
    n = (int)(input())
    return n
n = cin()
for i in range(n):
    l,r,d= list(map(int,input().split()))
    if(l>d): print(d)
    else:
        R=r+d
        print(R-R%d)


