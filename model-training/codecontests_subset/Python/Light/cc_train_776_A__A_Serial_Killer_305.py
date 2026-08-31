l1,l2=input().split()
number=int(input())
newOne=""
newTwo=""
print(l1,l2)
for i in range(number):
    newOne,newTwo=input().split()
    if l1==newOne:
        l1=newTwo
    elif l2==newOne:
        l2=newTwo
    print(l1,l2)