n=int(input())
count=0
list1=list(map(int,input().split(" ")))
list2=list(map(int,input().split(" ")))
list3=list(map(int,input().split(" ")))
list1.sort()
list2.sort()
list3.sort()
for i,j in enumerate(list2):
    if j in list1:
        list1.remove(list1[list1.index(j)])
print(list1[0])
for i,j in enumerate(list3):
    if j in list2:
        list2.remove(list2[list2.index(j)])
print(list2[0])

