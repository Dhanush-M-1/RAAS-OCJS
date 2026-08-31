n=int(input())
list1=[]
for i in range(0,3):
    list1.append((list(map(int,input().split()))))
val1=sum(list1[0])-sum(list1[1])
val2=sum(list1[1])-sum(list1[2])
print(val1)
print(val2)
