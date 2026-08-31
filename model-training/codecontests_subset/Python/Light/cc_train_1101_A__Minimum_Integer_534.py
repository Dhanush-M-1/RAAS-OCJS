q = int(input())
for _ in range(q):
    l, r, d = map(int, input().split())
    q1 = l//d
    if q1>0:
        if l%d==0:
            if q1>1:
                print(d)
            else:
                q2= r//d
                print((q2+1)*d)
        else:
            print(d)
    else:
        q2 = r//d
        print((q2+1)*d)
