str1=input()
L=str1.split(' ')
a=int(L[0])
b=int(L[1])
number=a
while a>=b:
    number+=1
    a-=b
    a+=1
print(number)