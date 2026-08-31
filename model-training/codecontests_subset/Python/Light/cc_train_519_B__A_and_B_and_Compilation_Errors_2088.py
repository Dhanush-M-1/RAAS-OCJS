n = input().split()
a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
c = [int(i) for i in input().split()]
x=0
for i in a:
	x = x^i
for i in b:
	x = x^i
num1 = x
x=0
for i in b:
	x = x^i
for i in c:
	x = x^i
num2 = x
print(num1,num2,sep="\n")
