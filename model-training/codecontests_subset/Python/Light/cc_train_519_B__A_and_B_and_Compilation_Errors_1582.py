#problem 519B
n=int(input())
list1=[int(x) for x in input().split()]
for i in range(2):
    list2=[int(x) for x in input().split()]
    print(sum(list1)-sum(list2))
    list1=list2.copy()
