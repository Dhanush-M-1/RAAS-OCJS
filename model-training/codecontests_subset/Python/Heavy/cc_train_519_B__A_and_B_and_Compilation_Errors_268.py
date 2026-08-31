n = int(input())
list1 = sorted(map(int,input().split()))
list2 = sorted(map(int,input().split()))
list3 = sorted(map(int,input().split()))
x = 0
y = 0
list4 = []
list5 = []
for i in range(len(list3)):
                if list2[i] != list1[i]:
                                x = 1
                                list5.append(list1[i])
                if list2[i] != list3[i]:
                                y = 1
                                list4.append(list2[i])
                if [x,y] == [1,1]:
                                break
if [x,y] == [0,0]:
                if list1[-2] == list2[-1]:
                                print(list1[-1])
                else:
                                print(list1[-2])
                print(list2[-1])
                exit()
elif [x,y] == [1,0]:
                print(list5[0])
                print(list2[-1])
                exit()
elif [x,y] == [0,1]:
                if list1[-2] == list2[-1]:
                                print(list1[-1])
                else:
                                print(list1[-2])
                print(list4[0])
                exit()
print(list5[0])
print(list4[0])

