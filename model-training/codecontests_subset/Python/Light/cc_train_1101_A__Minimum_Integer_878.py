num = int(input())
for i in range(num):
    l,r,d = tuple(map(int,input().split()))
    if d<l or d>r :
        print(d)
    else :
        print((1+int(r/d))*d)
