from math import factorial
t = int(input())
num = input()[:t]
length = t//11
eigth = num.count('8')
zero = num.count('0')
if(eigth==0):
    print(0)
elif(eigth>length):
    print(length)
else:
    print(eigth)