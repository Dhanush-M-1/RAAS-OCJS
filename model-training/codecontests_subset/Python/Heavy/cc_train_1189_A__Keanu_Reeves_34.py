n=int(input())
s=input()
l=list(s)
l1=l[1:]
def listToString(s):
    str1 = ""
    for ele in s:
        str1 += ele
    return str1
if(l.count("0") != l.count("1")):
    print(1)
    print(listToString(l))
else:
    if (l1.count("0") == l1.count("1")):
        if (l[0] == "0" and l1[0] == "0"):
            print(2)
            print("00",listToString(l1[1:]))
        elif (l[0] == "0" and l1[0] == "1"):
            print(3)
            print(0, 1,listToString(l1[1:]))
        elif (l[0] == "1" and l1[0] == "0"):
            print(3)
            print(0, 1,listToString(l1[1:]))
        else:
            print(2)
            print("11",listToString(l1[1:]))
    else:
        print(2)
        print(l[0],listToString(l1))
