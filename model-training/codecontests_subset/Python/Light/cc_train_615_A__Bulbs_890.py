def check(xx,m):
    for i in range(1,m+1):
        if str(i) not in set(xx):
            return False
    return True

n,m = map(int,input().split())
l = []
for i in range(n):
    l.append(input().split(" "))
ff = [j for i in l for j in i[1:]]
if check(ff,m):
    print("YES")
else:
    print("NO")