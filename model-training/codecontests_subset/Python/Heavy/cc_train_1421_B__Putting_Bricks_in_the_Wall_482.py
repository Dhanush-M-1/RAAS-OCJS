for i in range(int(input())):
    a=int(input())
    b=[]
    for i in range(a):
        b.append(input().strip())
    
    if b[1][1]==b[0][2] and b[1][1]==b[2][0]:
        if b[0][1]==b[1][0]:
            if b[0][1]==b[1][1]:
                print(2)
                print(1,2)
                print(2,1)
            else:
                print(0)
        else:
            if b[0][1]==b[1][1]:
                print(1)
                print(1,2)
            else:
                print(1)
                print(2,1)
    elif b[0][2]==b[2][0]:
        if b[0][1]==b[1][0]:
            if b[0][1]==b[1][1]:
                print(1)
                print(2,2)
            else:
                print(2)
                print(1,3)
                print(3,1)
        else:
            if b[0][1]==b[1][1]:
                print(2)
                print(2,2)
                print(2,1)
            else:
                print(2)
                print(2,2)
                print(1,2)
    elif b[0][2]==b[1][1]:
        if b[0][1]==b[1][0]:
            if b[0][1]==b[1][1]:
                print(2)
                print(2,2)
                print(1,3)
            else:
                print(1)
                print(3,1)
        else:
            if b[0][1]==b[1][1]:
                print(2)
                print(1,2)
                print(3,1)
            else:
                print(2)
                print(2,1)
                print(3,1)
    elif b[2][0]==b[1][1]:
        if b[0][1]==b[1][0]:
            if b[0][1]==b[1][1]:
                print(2)
                print(2,2)
                print(3,1)
            else:
                print(1)
                print(1,3)
        else:
            if b[0][1]==b[1][1]:
                print(2)
                print(1,2)
                print(1,3)
            else:
                print(2)
                print(2,1)
                print(1,3)
    