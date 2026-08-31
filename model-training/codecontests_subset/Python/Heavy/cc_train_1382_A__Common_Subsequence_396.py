t=int(input())
cfl=[]
for j in range(t):
    n, m=map(int, input().split())
    al=list(map(int, input().split()))
    bl=list(map(int, input().split()))
    cl=[]
    for i in range(n):
        if(al[i] in bl):
            cl.append(al[i])
            break
    cfl.append(cl)
    j+=1
for it in range(len(cfl)):
    if(bool(cfl[it])):
        print("YES")
        print(len(cfl[it])," ",end='')
        for x in range(len(cfl[it])):
            print(cfl[it][x]," ",end='')
        print("")
    else:
       print("NO")

