#Help Vasilisa the Wise 2
r1,r2 = map(int,input().split())
c1,c2= map(int,input().split())
d1,d2 = map(int,input().split())
arr = [] ;a,b,c,d = 0,0,0,0
arr2 = [1,2,3,4,5,6,7,8,9]
for i  in range(1,10):
    arr = []
    a = i; arr.append(a)
    if (r1-a)not in arr and (r1-a) in arr2 :
        b = r1-a ; arr.append(b)
    if (c2-b)not in arr and (c2-b) in arr2:
        d = c2-b ; arr.append(d)
    if (r2-d not in arr) and r2-d in arr2:
        c = r2-d ; arr.append(c)
    if (a+c == c1 and b+d == c2 and a+b == r1 and  c+d == r2 and a+d == d1 and b+c == d2):
        print(a,b)
        print(c,d)
        exit()
print(-1)