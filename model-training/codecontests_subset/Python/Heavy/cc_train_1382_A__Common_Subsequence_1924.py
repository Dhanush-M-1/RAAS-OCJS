t=int(input())
for i in range(t):
    s=input()
    s1=s.split()
    n=int(s1[0])
    m=int(s1[1])
    l1=[]
    l2=[]
    k=input()
    k1=k.split()
    for j in k1:
        l1.append(int(j))
    p=input()
    p1=p.split()
    for k in p1:
        l2.append(int(k))
    if n<m:
        a=0
        for i in l1:
            if i in l2:
                print("YES")
                print(1,i)
                a=1
                break
        if a==0:
            print("NO")
    else:
        b=0
        for i in l2:
            if i in l1:
                print("YES")
                print(1,i)
                b=1
                break
        if b==0:
            print("NO")