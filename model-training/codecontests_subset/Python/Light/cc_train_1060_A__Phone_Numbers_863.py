count=0
n=int(input())
number=str(input())

for i in range(n):
    if (number[i]=="8"):
        count+=1;


if (n//11 > count):
    print(count);
else:
    print(n//11)