#519B-A and B and Compilation Errors
n=int(input())
list1=[int(x) for x in input().split(' ')]
list2=[int(x) for x in input().split(' ')]
list3=[int(x) for x in input().split(' ')]
list1.sort()
list2.sort()
list3.sort()
a=0
b=0
for i in range(n-1):
    if list1[i] != list2[i]:
        a=1
        print(list1[i])
        break
if a == 0:
    print(list1[n-1])
for i in range(n-2):
    if list2[i] != list3[i]:
        b=1
        print(list2[i])
        break
if b == 0:
    print(list2[n-2])
