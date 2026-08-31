a=int(input())
list1=list(map(int,input().split()))
list2=list(map(int,input().split()))
list3=list(map(int,input().split()))
for i in range(1,4):
    exec('list{}.sort()'.format(i))
flag1=1
flag2=1

for i in range(len(list1)):
        try:
            if flag1:
                if list1[i]!=list2[i] :
                    b=list1[i]
                    flag1=0
        except:
            b=list1[i]
            flag1=0
        try:
            if flag2:
                if list2[i] != list3[i]:
                    c=list2[i]
                    flag2= 0
        except:
            c=list2[i]
            flag2=0
        if not flag1 and not flag2:
            break

print(b)
print(c)
