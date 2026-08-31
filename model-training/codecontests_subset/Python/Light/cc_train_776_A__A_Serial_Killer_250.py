a = input()
a = a.split(' ')
x= []
x+=a;
j= int(input())
for i in range(j):
        a1 = input()
        a1 = a1.split(' ')
        if a[0] == a1[0]:
                a[0] = a1[1]
        elif a[0] == a1[1]:
                a[0] = a1[0]
        elif a[1] == a1[0]:
                a[1] =a1[1]
        elif a[1] == a1[1]:
                a[1] =a1[0]
        x +=a
for k in range(0,2*j+1,2):
        print(x[k],x[k+1])
