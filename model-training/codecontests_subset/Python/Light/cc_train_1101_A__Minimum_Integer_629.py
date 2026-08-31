n=int(input())
for i in range(n):
    l=input()
    l1=l.split()
    n1=int(l1[0])
    n2=int(l1[1])
    n3=int(l1[2])
    while True:
        if n3<n1 or n3>n2:
            break
        else:
            n3*=(int(n2/n3)+1)
    print(n3)