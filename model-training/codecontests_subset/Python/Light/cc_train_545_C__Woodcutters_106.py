n = int(input())
a = []
for i in range(n):
    x,h = map(int,input().split())
    a.append([x,h])
s = 0
i = 0
e = 0
while (i < len(a)):
    if (i == 0):
        s = s + 1
    elif (i == len(a) - 1):
        s = s + 1
        break
    else:
        if ((abs(a[i][0] - a[i-1][0])) > a[i][1]):
            s = s + 1
        else:
            if ((abs(a[i+1][0] - a[i][0])) > a[i][1]):
                a[i][0] = a[i][0] + a[i][1]
                s = s + 1
    i = i + 1
print(s)