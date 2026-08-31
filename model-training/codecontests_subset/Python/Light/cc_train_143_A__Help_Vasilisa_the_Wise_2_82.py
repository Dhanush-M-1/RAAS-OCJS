r1,r2 = map(int,input().split())
c1,c2 = map(int,input().split())
d1,d2 = map(int,input().split())
c = abs(r1-c1-d2)//2
b = abs(r2-c2-d2)//2
a = abs(r1-b)
d = abs(c2-b)
res = [a,b,c,d]
if a+b != r1 or c+d != r2 or a+d != d1 or b+c != d2:
    print(-1)
else:
    for i in range(4):
        if res.count(res[i])>1 or res[i] >9 or res[i] < 1:
            print(-1)
            break
    else:
        print(a,b)
        print(c,d)
