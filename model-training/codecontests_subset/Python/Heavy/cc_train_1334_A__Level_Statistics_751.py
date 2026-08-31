
t = int(input())
for m in range(t):
    n = int(input())
    la = 0
    lb = 0
    flag = 0
    
    l = [] 
    for _ in range(n):
        a, b = input().split()
        a = int(a)
        b = int(b)
        l.append((a,b))
 
    for _ in range(n):
        a, b = l[_][0],l[_][1]
        
        if a < la:
            print("NO")
            flag = 1
            break
        if b < lb:
            print("NO")
            flag = 1
            break
        if a < b:
            print("NO")
            flag = 1
            break
        if a - la < b - lb:
            print("NO")
            flag = 1
            break
        la = a
        lb = b
        
        
    if flag == 0:
        print("YES")
        