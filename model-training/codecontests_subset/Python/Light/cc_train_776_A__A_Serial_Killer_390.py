a,b=input().split()
print(a,b)
for i in range(int(input())):
    c,d=input().split()
    if a==c:
        a=a.replace(a,d)
        print(a,b)
    elif b==c:
        b=b.replace(b,d)
        print(a,b)
