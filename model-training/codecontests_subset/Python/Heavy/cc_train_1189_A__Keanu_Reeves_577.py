n=int(input())
s=str(input())
l1=[]
l2=[]
for i in range (len(s)):
    l1.append(s[i])
a=[]
b=l1[0]
if n==1:
    print("1")
    print(l1[0])
else:


    if n%2==0:
        p=[]
        if l1.count("1")!=l1.count("0"):
            print("1")
            for i in range (len(l1)):
                print(l1[i],end="")
        else:

            print("2")
            print(l1[0],end=" ")
            for i in range (1,n):
                print(l1[i],end="")


    else:
        print("1")
        for i in range (n):
            print(l1[i],end="")