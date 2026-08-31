n = int(input())
p = n
x = []
h = []
while(p>0):
    p = p-1
    a,b = map(int,input().split())
    x.append(a)
    h.append(b)
c = 0
table = [0]*(n)
table[0] = -1
table[n-1] = 1
for i in range(1,n-1):
    if table[i-1] == -1:
        if x[i]-x[i-1]>h[i]:
            table[i] = -1
            c = c+1
        else:
            if x[i+1]-x[i]>h[i]:
                table[i] = 1
                c = c+1
    elif table[i-1] == 0:
        if x[i]-x[i-1] >h[i]:
            table[i] = -1
            c = c+1
        else:
            if x[i+1]-x[i]>h[i]:
                c = c+1
                table[i] = 1
    else:
        if x[i]-x[i-1]-h[i-1]>h[i]:
            table[i] = -1
            c = c+1
        else:
            if x[i+1]-x[i]>h[i]:
                table[i] = 1
                c = c+1
if n<2:
    print(1)
else:
    print(c+2)
        
        