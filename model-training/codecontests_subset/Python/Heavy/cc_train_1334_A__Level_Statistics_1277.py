x = int(input())
for i in range(x):
    n = int(input())
    vetor = [[0,0] for a in range(n)]
    flag = True
    anteriorP = 0
    anteriorS = 0
    for a in range(n):
        b = list(map(int,input().split(" ")))
        if(b[0] < anteriorP):
            flag = False
        elif(b[1]<anteriorS):
            flag = False
        elif(b[1]>b[0]):
            flag = False
        elif(b[1]-anteriorS>b[0]-anteriorP):
            flag = False
        else:
            anteriorP = b[0]
            anteriorS = b[1]
    if(flag):
        print("YES")
    else:
        print("NO")
