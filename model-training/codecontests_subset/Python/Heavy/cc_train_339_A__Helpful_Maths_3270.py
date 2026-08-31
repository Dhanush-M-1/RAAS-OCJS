d=str(input())
one=0
two=0
three=0
for i in range(len(d)):
    if(d[i]=="1"):
        one+=1
    if(d[i]=="2"):
        two+=1
    if(d[i]=="3"):
        three+=1
for i in range(len(d)//2):
    if(one>0):
        print("1+",end="")
        one-=1
    elif(two>0):
        print("2+",end="")
        two-=1
    elif(three>0):
        print("3+",end="")
        three-=1


if(one>0):
    print("1",end="")
    one-=1
elif(two>0):
    print("2",end="")
    two-=1
elif(three>0):
    print("3",end="")
    three-=1
