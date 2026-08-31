t = int(input())
for _ in range(t):
    a = int(input())
    lis = []
    for j in range(a):
        if j == 0:
            sh = list(input())
            sh[0] = "7"
            sh = list(map(int, sh)) 
        elif j == a-1:
            sh = list(input())
            sh[-1] = "7"
            sh = list(map(int, sh)) 
        else:
            sh = list(input())
            sh = list(map(int, sh))
        lis.append(sh)
    # print(lis)
    if lis[0][1] == 0 and lis[1][0] == 0 and lis[-1][-2] == 0 and lis[-2][-1] == 0:
        print(2)
        print("1 2")
        print("2 1")
    elif lis[0][1] == 1 and lis[1][0] == 0 and lis[-1][-2] == 0 and lis[-2][-1] == 0:
        print(1)
        print("2 1")
    elif lis[0][1] == 0 and lis[1][0] == 1 and lis[-1][-2] == 0 and lis[-2][-1] == 0:
        print(1)
        print("1 2")
    elif lis[0][1] == 1 and lis[1][0] == 1 and lis[-1][-2] == 0 and lis[-2][-1] == 0:
        print(0)
        

    elif lis[0][1] == 0 and lis[1][0] == 0 and lis[-1][-2] == 1 and lis[-2][-1] == 1:
        print(0)
    elif lis[0][1] == 1 and lis[1][0] == 0 and lis[-1][-2] == 1 and lis[-2][-1] == 1:
        print(1)
        print("1 2")
    elif lis[0][1] == 0 and lis[1][0] == 1 and lis[-1][-2] == 1 and lis[-2][-1] == 1:
        print(1)
        print("2 1")
    elif lis[0][1] == 1 and lis[1][0] == 1 and lis[-1][-2] == 1 and lis[-2][-1] == 1:
        print(2)
        print("1 2")
        print("2 1") 



    elif lis[0][1] == 0 and lis[1][0] == 0 and lis[-1][-2] == 1 and lis[-2][-1] == 0:
        print(1)
        print("{} {}".format(a-1,a))
    elif lis[0][1] == 1 and lis[1][0] == 0 and lis[-1][-2] == 1 and lis[-2][-1] == 0:
        print(2)
        print("1 2")
        print("{} {}".format(a-1,a))
    elif lis[0][1] == 0 and lis[1][0] == 1 and lis[-1][-2] == 1 and lis[-2][-1] == 0:
        print(2)
        print("1 2")
        print("{} {}".format(a,a-1))
    elif lis[0][1] == 1 and lis[1][0] == 1 and lis[-1][-2] == 1 and lis[-2][-1] == 0:
        print(1)
        print("{} {}".format(a,a-1))


    elif lis[0][1] == 0 and lis[1][0] == 0 and lis[-1][-2] == 0 and lis[-2][-1] == 1:
        print(1)
        print("{} {}".format(a,a-1))
    elif lis[0][1] == 1 and lis[1][0] == 0 and lis[-1][-2] == 0 and lis[-2][-1] == 1:
        print(2)
        print("1 2")
        print("{} {}".format(a,a-1))
    elif lis[0][1] == 0 and lis[1][0] == 1 and lis[-1][-2] == 0 and lis[-2][-1] == 1:
        print(2)
        print("{} {}".format(a,a-1))
        print("2 1")
    elif lis[0][1] == 1 and lis[1][0] == 1 and lis[-1][-2] == 0 and lis[-2][-1] == 1:
        print(1)
        print("{} {}".format(a-1,a))