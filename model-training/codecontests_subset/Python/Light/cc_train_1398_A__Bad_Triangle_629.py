t=int(input())
def check(a,b,c):
    if c>=b+a:
        return True
    else:
        return False
while t:
    t-=1
    n=int(input())
    a=[int(i) for i in input().split()]
    a.sort()
    if check(a[0],a[1],a[-1]):
        print(1,2,n)
    else:
        print(-1)

