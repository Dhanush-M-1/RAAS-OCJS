t = int(input())
for _ in range(t):
    n,m = list(map(int,input().rstrip().split()))
    a = list(map(int,input().rstrip().split()))
    b = list(map(int,input().rstrip().split()))
    number = 0 
    if len(a) > len(b):
        for x in b:
            if x in a:
                number = x
                break
    else:
        for x in a:
            if x in b:
                number = x
                break
    
    if number == 0:
        print("NO")
    else:
        print("YES")
        print(1,number)
