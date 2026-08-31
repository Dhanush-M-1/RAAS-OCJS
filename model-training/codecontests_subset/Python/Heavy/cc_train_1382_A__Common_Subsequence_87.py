t = int(input())
while t:
    n , m = map(int , input().split())
    a = list(map(int , input().split()))
    b = list(map(int , input().split()))
    check = 0
    smallest_l = 1
    
    if n >= m:
        for i in range(len(b)):
            if b[i] in a:
                k = b[i]
                check = 1
                break
    else:
        for i in range(len(a)):
            if a[i] in b :
                k = a[i]
                check = 1
                break
            
    if check == 0:
        print("NO")
    else:
        print("YES")
        print(smallest_l , k)
        
    t -= 1
        
    