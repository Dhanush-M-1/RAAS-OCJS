a=list(input())
k,l,n = a.count("1"),a.count("2"),a.count("3")

if n!=0:
    for i in range(k):
        print("1","+",sep="",end="")
    for i in range(l):
        print("2","+",sep="",end="")
    for i in range(n-1):
        print("3","+",sep="",end="")
    print("3")
else:
    if l!=0:
        for i in range(k):
            print("1","+",sep="",end="")
        for i in range(l-1):
            print("2","+",sep="",end="")
        print("2")
    else:
        for i in range(k-1):
            print("1","+",sep="",end="")
        print("1")