t = int(input())
for _  in range(t):
    n = int(input())
    
    l = [int(x) for x in input().split()]
    a  =l[0]
    b = l[1]
    c = l[-1]
    if a+b > c:
        print(-1)
    else:
        print(1, 2, n)