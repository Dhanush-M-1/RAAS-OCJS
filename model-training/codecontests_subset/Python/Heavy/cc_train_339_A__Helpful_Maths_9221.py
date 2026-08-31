st = str(input())

ones = 0
twos = 0
threes = 0

for i in st:
    if i == "1":
        ones += 1
    elif i == "2":
        twos += 1
    elif i == "3":
        threes +=1


if ones > 0:
    print("1+"*(ones-1),end = "")
    if(twos or threes):
        print("1+",end="")
    else:
        print("1",end = "")
if twos > 0:
    print("2+"*(twos-1),end = "")
    if threes:
        print("2+",end = "")
    else:
        print("2",end = "")
if threes > 0:
    print("3+"*(threes - 1),"3",sep = "",end = "")