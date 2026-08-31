T = int(input())
for _ in range(T):
    n = int(input())
    a = []
    b = []
    for i in range(n):
        k, l = map(int, input().split())
        a.append(k)
        b.append(l)
    # print(arr)
    diff1 = [0]*(n-1)
    diff2 = [0]*(n-1)

    for i in range(1, n):
        diff1[i-1] = a[i] - a[i-1]
        diff2[i-1] = b[i] - b[i-1]
    ans = True
    if a[0] < b[0] or a[0] < 0 or b[0] < 0:
        ans = False
        
    else:
        for i in range(n-1):
            if diff1[i] < 0:
                ans = False
            
            elif diff2[i] < 0:
                ans = False
                
            else:
                if diff1[i] < diff2[i]:
                    ans = False
        
                elif diff1[i] == 0 and diff2[i] != 0:
                    ans = False
                    

    if ans:
        print("YES")
    else:
        print("NO")
