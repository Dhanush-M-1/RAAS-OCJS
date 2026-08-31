q = int(input())
for _ in range(q):
    l,r,d = map(int,input().split())
    if d==1:
        if l!=1:
            print(1)
        else:
            print(r+1)
    else:
        if l%d ==0:
            check = (l//d) - 1
        else:
            check = l//d
            
        check2 = r//d + 1
            
        if check>0:
            print(d)
        else:
            print(check2*d)