def check(a,b,c):
    l=[a,b,c]
    l.sort()
    if (l[0]+l[1])>l[2]:
        return False
    return True
T=int(input())
for _ in range(T):
    n=int(input())
    arr=list(map(int,input().split()))
    if n<=2:
        print(-1)
        continue    
    if check(arr[0],arr[1],arr[-1]):
        print("%d %d %d"%(1,2,n))
    else:
        print(-1)
