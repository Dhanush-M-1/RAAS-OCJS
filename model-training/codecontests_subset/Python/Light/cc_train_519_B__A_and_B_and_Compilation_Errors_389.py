n = int(input())
list1 = [int(i) for i in input().split()]
list2 = [int(j) for j in input().split()]
list3 = [int(k) for k in input().split()]
print(sum(list1)-sum(list2), sum(list2)-sum(list3))