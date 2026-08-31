t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(i) for i in input().split()]
    b = []
    for i in range(len(a)):
        if a[i]==-1:
            if i==0:
                if a[1]!=-1:
                    b.append(a[1])
            elif i==len(a)-1:
                if a[n-2]!=-1:
                    b.append(a[n-2])
            else:
                if a[i-1]!=-1:
                    b.append(a[i-1])
                if a[i+1]!=-1:
                    b.append(a[i+1])
##    print(b)
    temp = -1
    for i in range(1, len(a)):
        if a[i]!=-1 and a[i-1]!=-1:
            temp = max(temp, abs(a[i-1]-a[i]))
    if len(b)==0:
        print(max(temp, 0), 1)
        continue
    elif len(b)==1:
        print(max(0, temp), b[0])
        continue
##    print(temp)
    k = min(b) + int((max(b) - min(b))/2)
    ans = max(temp, max(b)-k, k-min(b))
    print(ans, k)
