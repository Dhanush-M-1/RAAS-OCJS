def ans(a):
    if len(a) == 1:
        return 1
    else:
        c = 2
        for i in range(1,len(a) - 1):
            if (a[i][0]-a[i-1][0])> a[i][1]:
                # print("i in if is",i,a[i-1],a[i],a[i+1])
                c = c + 1
                # a[i][0] = a[i][0] - a[i][1] 
            elif (a[i+1][0]-a[i][0])> a[i][1]:
                # print("i in elif is",i,a[i-1],a[i],a[i+1])
                c = c + 1
                a[i][0] = a[i][0]+ a[i][1]
            else:
                pass
        return c

d = []
n = int(input())
for j in range(n):
    a = input().split()
    if True:
        a = [int(i) for i in a]
        d.append(a)
print(ans(d))