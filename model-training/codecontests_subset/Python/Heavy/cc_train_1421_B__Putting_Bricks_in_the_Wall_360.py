def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) ]))
def invr():
    return(map(int,input().split()))

n = inp()

for _ in range(n):
    x = inp()
    l = []
    for j in range(x):
        l.append(insr())

    #print(l)

    if(l[0][1] == '1' and l[1][0] == '1' and l[-1][-2] == '1' and l[-2][-1] == '1'):
        print(2)
        print("1 2")
        print("2 1")
    elif(l[0][1] == '0' and l[1][0] == '0' and l[-1][-2] == '0' and l[-2][-1] == '0'):
        print(2)
        print("1 2")
        print("2 1")
    elif(l[0][1] == '1' and l[1][0] == '1' and l[-1][-2] == '0' and l[-2][-1] == '0'):
        print(0)
    elif(l[0][1] == '0' and l[1][0] == '0' and l[-1][-2] == '1' and l[-2][-1] == '1'):
        print(0)
    elif(l[0][1] == '1' and l[1][0] == '0' and l[-1][-2] == '1' and l[-2][-1] == '1'):
        print(1)
        print("1 2")
    elif(l[0][1] == '0' and l[1][0] == '1' and l[-1][-2] == '1' and l[-2][-1] == '1'):
        print(1)
        print("2 1")
    elif(l[0][1] == '1' and l[1][0] == '1' and l[-1][-2] == '1' and l[-2][-1] == '0'):
        print(1)
        print(str(x) + " " + str(x-1))
    elif(l[0][1] == '1' and l[1][0] == '1' and l[-1][-2] == '0' and l[-2][-1] == '1'):
        print(1)
        print(str(x-1) + " " + str(x))
    elif(l[0][1] == '0' and l[1][0] == '1' and l[-1][-2] == '0' and l[-2][-1] == '0'):
        print(1)
        print("1 2")
    elif(l[0][1] == '1' and l[1][0] == '0' and l[-1][-2] == '0' and l[-2][-1] == '0'):
        print(1)
        print("2 1")
    elif(l[0][1] == '0' and l[1][0] == '0' and l[-1][-2] == '1' and l[-2][-1] == '0'):
        print(1)
        print(str(x-1) + " " + str(x))
    elif(l[0][1] == '0' and l[1][0] == '0' and l[-1][-2] == '0' and l[-2][-1] == '1'):
        print(1)
        print(str(x) + " " + str(x-1))
    elif(l[0][1] == '1' and l[1][0] == '0' and l[-1][-2] == '0' and l[-2][-1] == '1'):
        print(2)
        print(str(x) + " " + str(x-1))
        print("1 2")
    elif(l[0][1] == '0' and l[1][0] == '1' and l[-1][-2] == '0' and l[-2][-1] == '1'):
        print(2)
        print(str(x) + " " + str(x-1))
        print("2 1")
    elif(l[0][1] == '0' and l[1][0] == '1' and l[-1][-2] == '1' and l[-2][-1] == '0'):
        print(2)
        print(str(x) + " " + str(x-1))
        print("1 2")
    elif(l[0][1] == '1' and l[1][0] == '0' and l[-1][-2] == '1' and l[-2][-1] == '0'):
        print(2)
        print(str(x) + " " + str(x-1))
        print("2 1")
