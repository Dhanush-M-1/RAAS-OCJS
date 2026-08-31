n=input()
t=int(input())
b=[]
s=0
d=""
c=0
for i in range(t):
    x=(input())
    b.append(x)
    d=d+x
if len(b)>1:
    if n in d:
        print("YES")
    else:
        if d.count(n[0])>=n.count(n[0]) and d.count(n[1])>=n.count(n[1]):
            if n[0]==n[1]:
                if b[1][1]==b[0][0]:
                    print("YES")
                else:
                    print("NO")
            else:
                for i in b:
                    if i[::-1]==n:
                        c=c+1
                    elif i[1]==n[0] or i[0]==n[1]:
                            s=s+1
                if s>=2 or c>=1:
                    print("YES")
                else:
                    print("NO")
        else:
            print("NO")
else:
    if b[0]==n or b[0][::-1]==n:
        print("YES")
    else:
        print("NO")
