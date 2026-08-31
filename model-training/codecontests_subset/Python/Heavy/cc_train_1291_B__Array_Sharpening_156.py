# 0 1 2 3 4 5
# 0 1 1 0
# 0 9 1 0

t = int(input())

for _ in range(t):
    
    n = int(input())
    a = list(map(int, input().split()))
    
    flag_r = False
    flag_l = False
    r = n-1
    l = 0
    for i in range(n):
        
        if flag_r == False and a[i] < i:
            r = i - 1
            flag_r = True
            # print("r",i)
        if flag_l == False and a[n-1-i] < i:
            # print("l",n-1-i)
            l = n-1-i +1
            flag_l = True
    
    if l <= r:
        print("Yes")
    else:
        print("No")
