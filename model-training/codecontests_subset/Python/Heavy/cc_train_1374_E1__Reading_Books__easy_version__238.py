a = input().split(" ")
list1 = []
list2 = []
list3 = []
for i in range(int(a[0])):
    b = input().split(" ")
    if(b[1]=="1"):
        if(b[2]=="1"):
            list1.append(int(b[0]))
        else:
            list2.append(int(b[0]))
    else:
        if(b[2]=="1"):
            list3.append(int(b[0]))
if(len(list1)+min(len(list2),len(list3))<int(a[1])):
    print(-1)
else:
    ans = 0
    ans1 = 0
    ans2 = 0
    list1_index = 0
    list2_index = 0
    list3_index = 0
    list1_len = len(list1)
    list2_len = len(list2)
    list3_len = len(list3)
    list1.sort()
    list2.sort()
    list3.sort()
    while(ans<int(a[1]) or ans1<int(a[1])):
        if(ans<int(a[1]) and ans1<int(a[1]) and list1_index<list1_len):
            if(list2_len<=list2_index or list3_len<=list3_index):
                tag = int(a[1])-min(ans,ans1)
                ans2+=sum(list1[list1_index:list1_index+tag])
                ans = int(a[1])
                ans1 = int(a[1])
            else:
                if(list1[list1_index]>list2[list2_index]+list3[list3_index]):
                    ans1+=1
                    ans+=1
                    ans2+=list2[list2_index]+list3[list3_index]
                    list2_index+=1
                    list3_index+=1
                else:
                    ans1+=1
                    ans+=1
                    ans2+=list1[list1_index]
                    list1_index+=1
        elif(ans<int(a[1])):
            if(list2_len<=list2_index):
                ans+=1
                ans2+=list1[list1_index]
                list1_index+=1
            else:
                ans+=1
                ans2+=list2[list2_index]
                list2_index+=1
        elif(ans1<int(a[1])):
            if(list3_len<=list3_index):
                ans1+=1
                ans2+=list1[list1_index]
                list1_index+=1
            else:
                ans1+=1
                ans2+=list3[list3_index]
                list3_index+=1
    print(ans2)