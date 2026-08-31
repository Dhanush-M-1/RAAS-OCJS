s = str(input())
n1 = 0 
n2 = 0
n3 = 0

for i in s :
    if i == "1" :
        n1 += 1
    elif i == "2" :
        n2 += 1
    elif i == "3":
        n3 += 1 

if  n2 == 0 and n3 == 0 :
    print((n1-1)*"1+" + "1")
elif  n1 == 0 and n3 == 0 :
    print((n2-1)*"2+" + "2")
elif  n1 == 0 and n2 == 0 :
    print((n3-1)*"3+" + "3")
elif n1 != 0 and n2 != 0 and n3 != 0 :
    print(n1*"1+"+  n2*"2+" + (n3-1)*"3+" + "3" )
elif n1 != 0 and n2 != 0 :
    print(n1*"1+" + (n2-1)*"2" + "2")
elif  n1 != 0 and n3 != 0  :
    print(n1*"1+" + (n3-1)*"3+" + "3")
elif n2 != 0 and n3 != 0  :
    print(n2*"2+" + (n3-1)*"3+" + "3")