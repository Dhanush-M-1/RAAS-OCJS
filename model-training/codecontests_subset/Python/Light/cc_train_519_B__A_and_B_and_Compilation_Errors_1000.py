x=int(input())
a=sorted(list(map(int,input().split())))
b=sorted(list(map(int,input().split())))
c=sorted(list(map(int,input().split())))


for i in range(len(a)):
    try:
        if b[i] == a[i]:
            pass
        else:
            print(a[i])
            break
    except:
        print(a[-1])
    
for i in range(len(b)):
    try:
        if b[i] == c[i]:
            pass
        else:
            print(b[i])
            break
    except:
        print(b[-1])