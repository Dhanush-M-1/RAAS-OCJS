length = int(input())
s = str(input())
e = sorted(s)
t = True
k=0
if len(e)%length==0:
    size = len(e)/length
    for i in range(int(size)):
        for j in range(length-1):
            if e[k]==e[k+1]:
                k+=1
            else:
                k+=1
                t = False
        k+=1
    if t == False: 
        print(-1)
    elif t==True:
        w = 0
        answer =""
        for i in range(int(size)):
            answer+=e[w]
            w+=length
        answer*=length
        print(answer)
else:
    print(-1)