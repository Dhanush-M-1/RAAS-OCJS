def minint(n, a):
    for i in range(n):
        l=a[i][0]
        r=a[i][1]
        d=a[i][2]
        if  l<= d<=r:
            print((r//d+1)*d)
        else:
            print(d)
n=int(input())
v=[]
for i in range(n):
    a = input().strip().split()
    a = list(map(int, a))
    v.append(a)
minint(n, v)