ansli=[]

while 1:
    n=input()
    if n=="0":
        break
    a=input().split()
    up=0
    down=1
    lu=0
    ru=0
    ld=0
    rd=0
    count=0
    for i in a:
        if i=="ru":
            ru=1
            rd=0
        elif i=="lu":
            lu=1
            ld=0
        elif i=="rd":
            rd=1
            ru=0
        elif i=="ld":
            ld=1
            lu=0

        if ru==1 and lu==1 and down==1:
            count+=1
            down=0
            up=1
        elif rd==1 and ld==1 and up==1:
            count+=1
            down=1
            up=0
    ansli.append(count)
    #print(count)
for i in ansli:
    print(i)

