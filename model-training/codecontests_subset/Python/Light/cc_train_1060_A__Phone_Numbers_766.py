number = input()
digits = tuple(input())


count=0

totalnum = int(number)//11
for el in digits:
    if el == "8":
        count+=1

if totalnum > count:
    print(count)
else:
    print(totalnum)