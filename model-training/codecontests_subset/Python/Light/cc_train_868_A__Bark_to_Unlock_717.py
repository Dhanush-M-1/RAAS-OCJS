pas = input()
l = []
for i in range(int(input())):
    l.append(input())
for i in l:
    if i==pas: 
        print("YES")
        exit(0)
knt1= 0
knt2 = 0
for i in l:
    if i[1] == pas[0]:
        knt1=1 
    if i[0] == pas[1]:
        knt2=1
    if knt1+knt2==2:
        print("YES")
        exit(0)
print("NO")
                                




