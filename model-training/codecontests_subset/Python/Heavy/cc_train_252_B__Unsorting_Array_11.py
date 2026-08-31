n=int(input())
a=[int(i) for i in input().split()]
b=len(set(a))
c=sorted(a,reverse=True)
if n==1 or n==2 or b==1:
    print("-1")
elif n==3:
    if b==2:
        if a[0]==a[2]:
            print("-1")
        elif a[0]==a[1]:
            print("2 3")
        else:
            print("1 2")
    elif a[1]!=max(a[0],a[1],a[2]):
        print(a.index(c[0])+1,"2")
    else:
            print(a.index(c[2])+1,"2")
elif n==4:
    if b==2:
        if a[0]==a[3]:
            if a[0]==a[1] or a[0]==a[2]:
                print("2 3")
            else:
                print("1 2")
        elif a[0]==a[1]:
            if a[0]==a[2]:
                print("4 3")
            else:
                print("2 3")
        elif a[0]==a[2]:
            print("1 2")
        elif a[1]==a[2]:
            print("1 2")
        elif a[1]==a[3]:
            print("1 2")
        else:
            print("2 3")
    elif b==3:
        if c[0]==c[1]:
            if a.index(c[3])!=2:
                print(a.index(c[3])+1,"3")
            elif a.index(c[3])!=1:
                print(a.index(c[3])+1,"2")
        else:
            if a.index(c[0])!=2:
                print(a.index(c[0])+1,"3")
            elif a.index(c[0])!=1:
                print(a.index(c[0])+1,"2")
    elif b==4:
        if a.index(c[0])!=2:
            print(a.index(c[0])+1,"3")
        elif a.index(c[0])!=1:
            print(a.index(c[0])+1,"2")
elif n>4:
    i=0
    while(a[i]==a[0]):
        i+=1
    if i>3:
        print(i+1,"2")
    else:
        d=list(a)
        for i in range (n-4):
            a.pop()
        c=sorted(a,reverse=True)
        b=len(set(c))
        if b==2:
            if a[0]==a[3]:
                if a[0]==a[1] or a[0]==a[2]:
                    print("2 3")
                else:
                    print("1 2")
            elif a[0]==a[1]:
                if a[0]==a[2]:
                    print("4 3")
                else:
                    print("2 3")
            elif a[0]==a[2]:
                print("1 2")
            elif a[1]==a[2]:
                print("1 2")
            elif a[1]==a[3]:
                print("1 2")
            else:
                print("2 3")
        elif b==3:
            if c[0]==c[1]:
                if a.index(c[3])!=2:
                    print(a.index(c[3])+1,"3")
                elif a.index(c[3])!=1:
                    print(a.index(c[3])+1,"2")
            else:
                if a.index(c[0])!=2:
                    print(a.index(c[0])+1,"3")
                elif a.index(c[0])!=1:
                    print(a.index(c[0])+1,"2")
        elif b==4:
            if a.index(c[0])!=2:
                print(a.index(c[0])+1,"3")
            elif a.index(c[0])!=1:
                print(a.index(c[0])+1,"2")