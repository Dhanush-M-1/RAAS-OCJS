n=int(input())
list1=list(map(int,input().split()))
list1.sort()

list2=list(map(int,input().split()))
list2.sort()

list3=list(map(int,input().split()))
list3.sort()
for i in range(len(list2)):
    if list1[i]!=list2[i]:
        print(list1[i])
        break
else:
    print(list1[-1])
for j in range(len(list3)):
    if list2[j]!=list3[j]:
        print(list2[j])
        break
else:
    print(list2[-1])

