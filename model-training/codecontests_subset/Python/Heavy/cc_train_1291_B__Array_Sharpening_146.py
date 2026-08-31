t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int,input().split()))

    if n == 1:
        print("YES")
    else:
        tmp = 0
        top = n-1
        for i in range(1,n):
            if tmp < a[i]:
                tmp += 1
            else:
                top = i
                tmp = a[i-1]
                break
        
        for i in range(top,n):
            if a[i] < tmp:
                tmp = a[i]
            else:
                tmp = tmp-1
                if tmp < 0:
                    print("NO")
                    break
        else:
            print("YES")