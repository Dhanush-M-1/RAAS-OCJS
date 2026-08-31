#HELPFULMATHS ACCEPTED

y=input(); x=len(y)
list1 = list(y)

"""for i in range(x-2):
    a=list1[i]
    b=list1[i+2]
    if i%2==0:
        if a<=b:
            i+=2
            print(i)
        elif a>b:
            c=a; a=b; b=c #a ile b nin yeri değişti
            del list1[i]
            list1.insert(i,a)
            del list1[i+2]
            list1.insert(i+2,b)
            i=0
    else:
        pass
for i in range(0,len(list1)):
    print(list1[i],end="")
print("")"""

list2=[]
for i in range(0,len(list1),2):
    list2.append(list1[i])
list2.sort()
for i in range(len(list2)-1):
    print(str(list2[i])+"+",end="")
print(list2[-1])
