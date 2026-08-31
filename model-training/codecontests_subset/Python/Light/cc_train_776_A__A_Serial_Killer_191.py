a,b=input().split()
print(a+" "+b)
n=int(input())
for i in range(n):
    c,d=input().split()
    if a==c:
        a=d
        print(a+" "+b)
    elif a==d:
        a=c
        print(a+" "+b)
    elif b==d:
        b=c
        print(a+" "+b)
    else:
        b=d
        print(a+" "+b)
