n = int(input())

x_l = []
h_l = []

if n == 1:
    print(1)
else:
    for i in range(n):
        (x, h) = map(int, input().split())
        x_l.append(x)
        h_l.append(h)
    
    ans = 2
    left = x_l[0]
    
    for i in range(1, n -1):
        if left < (x_l[i] - h_l[i]):
            ans += 1
            left = x_l[i]
        elif (x_l[i] + h_l[i] < x_l[i + 1]):
            ans += 1
            left = x_l[i] + h_l[i]
        else:
            left = x_l[i]
    
    print(ans)