t = int(input())
while t > 0:
    ans=0
    n = int(input())
    a = [int(ele) for ele in input().split()]
    b = set([])
    for i in range(n):
        if a[i] == -1:
            if i == 0:
                if a[i+1] != -1:
                    b.add(a[i+1])
            elif i > 0 and i < n-1:
                if a[i-1] != -1:
                    b.add(a[i-1])
                if a[i+1] != -1:
                    b.add(a[i+1])
            else:
                if a[i-1] != -1:
                    b.add(a[i-1])
    if a.count(-1) == 0:
        diff = -1
        for i in range(n-1):
            if abs(a[i]-a[i+1]) > diff:
                diff = abs(a[i]-a[i+1])
        print(diff, 1+ans)
    else:
        if len(b) == 0:
            for i in range(n):
                if a[i] == -1:
                    a[i] = 1
            print(0, 1+ans)
        else:
            mini = min(b)
            maxi = max(b)
            ele = int((mini+maxi)/2)
            for i in range(n):
                if a[i] == -1:
                    a[i] = ele
            diff = -1
            for i in range(n-1):
                if abs(a[i]-a[i+1]) > diff:
                    diff = abs(a[i]-a[i+1])
            print(diff, ele+ans)
    t -= 1


