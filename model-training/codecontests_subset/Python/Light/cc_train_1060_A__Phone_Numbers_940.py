n= int (input())
str = input()
solution=0
eights= str.count("8")
Num=n//11
while n>=11 and eights >0:
    if n>=11 and eights >0:
        solution += 1
        eights-=1
        if Num==solution:
            break
    else:
        break

print (solution)