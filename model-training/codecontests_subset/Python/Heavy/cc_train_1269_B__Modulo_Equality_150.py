inp = input().split()
n = int(inp[0])
m = int(inp[1])
a = list(map(int,input().split()))
b = list(map(int,input().split()))
a.sort()
b.sort()

def f(a,b, m):
    if (b-a)%m < 0 : return (b-a)%m + m
    else : return (b-a)%m

ans = -1

for i in range(n):
    bisa = False
    cnt = 0
    tmp = f(a[0],b[i],m)
    for j in range(n):
        if (f(a[j],b[(i+j)%n],m) != tmp):
            break
        cnt += 1
    if cnt == n :
        if not bisa :
            bisa = True
            ans = tmp
        else:
            ans = min(ans,tmp)

print(ans)
            
