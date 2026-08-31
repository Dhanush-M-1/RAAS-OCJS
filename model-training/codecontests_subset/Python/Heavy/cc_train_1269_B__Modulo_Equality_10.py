#code
n , m = map(int,input().split())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
a = sorted(a)
b = sorted(b)
if a==b:
    print(0)
else:
    diff = 0
    al = []
    for i in range(n):
        if b[i]>a[0]:
            al.append(b[i]-a[0])
        else:
            al.append(m+b[i]-a[0])
    goal = al.copy()
    goal = sorted(goal)
    for i in goal:
        aa = a.copy()
        for j in range(n):
            aa[j] = (aa[j]+i)%m
        aa = sorted(aa)
        if aa == b:
            print(i)
            break