from sys import stdin,stdout
input = stdin.readline
#print = stdout.write
n,k = map(int,input().split())
com = []
a = []
b = []
for _ in range(n):
    t,ai,bi = map(int,input().split())
    if ai==1==bi:
        com+=[t]
    elif ai==1:
        a+=[t]
    elif bi==1:
        b+=[t]
a.sort(reverse=True)
b.sort(reverse=True)
com.sort(reverse=True)


ak,bk = 0,0
ans = 0
while ak!=k and bk!=k:
    if a and b and com:
        if a[-1]+b[-1]<=com[-1]:
            ans+=a[-1]+b[-1]
            a.pop()
            b.pop()
        else:
            ans+=com[-1]
            com.pop()
        ak+=1
        bk+=1
    elif a and b:
        ans+=a[-1]+b[-1]
        a.pop()
        b.pop()
        ak+=1
        bk+=1
    elif com:
        ans+=com[-1]
        com.pop()
        ak+=1
        bk+=1
    else:
        print(-1)
        break
else:
    print(ans)