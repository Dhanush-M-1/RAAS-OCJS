
n,m = map(int,input().split())


list1 = list(map(int,input().split()))
list2 = list(map(int,input().split()))
list1.sort()
list2.sort()
temp = list()
for i in range(n):
    x = (list2[0]-list1[i])%m
    temp.append(x)
temp.sort()
for i in range(len(temp)):
    temp2 = list()
    f1=0
    for j in range(n):
        temp2.append((list1[j]+temp[i])%m)
    temp2.sort()
    for j in range(n):
        if temp2[j]!= list2[j]:
            f1=1
            break


    if f1==0:
        print(temp[i])
        break



