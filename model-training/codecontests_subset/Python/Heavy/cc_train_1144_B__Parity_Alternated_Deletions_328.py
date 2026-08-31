# cook your dish here
n = int(input())
a = list(map(int, input().split()))
se = 0
so =0
x = []
y = []
for i in range(n):
    if a[i]%2==0:
        se = se + 1
        x.append(a[i])
    else:
        so = so + 1
        y.append(a[i])
if abs(se-so)<=1:
    print("0")
else:
    if se>so:
        x.sort()
        s = 0
        for i in range(len(x) -(so+1)):
            s = s + x[i]
        print(s)
    else:
        y.sort()
        s = 0
        for i in range(len(y) -(se+1)):
            s = s + y[i]
        print(s)