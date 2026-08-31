# # Created by Prabhat kumar jha and 18/10/20
#
# t = int(input())
# for i in range(t):
#     a, b = [int(i) for i in input().split(" ")]
#     print(a^b)


t = int(input())
for i in range(t):
    n = int(input())
    l = []
    for i in range(n):
        l.append(input())
    a = int(l[0][1])
    b = int(l[1][0])
    c = int(l[-1][-2])
    d = int(l[-2][-1])

    s1 = a+b
    s2 = c+d
    if {s1, s2} == {0, 2}:
        print(0)
    elif {s1, s2} == {1}:
        print(2)
        print("1 2")
        if a!=c:
            print(str(n)+" "+str(n-1))
        else:
            print(str(n-1) + " " + str(n))
    elif {s1, s2} == {2} or {s1, s2} == {0}:
        print(2)
        print(str(n) + " " + str(n - 1))
        print(str(n-1) + " " + str(n))
    else:
        print(1)
        if s1==1 and s2==2:
            if a==0:
                print("2 1")
            else:
                print("1 2")
        elif s1==2 and s2==1:
            if c==0:
                print(str(n-1)+" "+str(n))
            else:
                print(str(n)+" "+str(n-1))
        elif s1==0 and s2==1:
            if c==0:
                print(str(n) + " " + str(n - 1))
            else:
                print(str(n - 1) + " " + str(n))
        else:
            if a==0:
                print("1 2")
            else:
                print("2 1")









