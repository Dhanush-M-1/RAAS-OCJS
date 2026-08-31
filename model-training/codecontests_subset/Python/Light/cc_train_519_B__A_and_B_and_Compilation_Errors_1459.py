error = int(input())

list1=input().split()
list2=input().split()
list3=input().split()
a=0
b=0
c=0
for i in list1:
 a += int(i)
for i in list2:
 b += int(i)
for i in list3:
 c += int(i)
print(a-b)
print(b-c)