a=int(input())
for i in range(a):
    b=int(input())
    c=input().split()
    if int(c[b-1])-(int(c[0])+int(c[1]))>=0:
        print(1,2,b)
    else:
        print(-1)