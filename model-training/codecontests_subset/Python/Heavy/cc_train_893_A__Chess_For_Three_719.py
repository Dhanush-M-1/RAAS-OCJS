n = int(input())
w = []
for i in range(0,n):
    w.append(int(input()))
p1 = 1
p2 = 2
flag = True
for i in range(0,n):
    if p1==w[i]:
        if p1==1:
            if p2==2:
                p2 = 3
            elif p2==3:
                p2 = 2
        elif p1==2:
            if p2==1:
                p2 = 3
            elif p2==3:
                p2 = 1
        else:
            if p2 ==1:
                p2 = 2
            elif p2==2:
                p2 = 1
    elif p2==w[i]:
        if p2==1:
            if p1==2:
                p1 = 3
            elif p1==3:
                p1 = 2
        elif p2==2:
            if p1==1:
                p1 = 3
            elif p1==3:
                p1 = 1
        else:
            if p1 ==1:
                p1 = 2
            elif p1==2:
                p1 = 1
    else:
        flag = False
if flag:
    print("YES")
else:
    print("NO")