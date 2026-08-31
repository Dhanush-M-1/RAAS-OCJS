n = int(input())

list1 = [int(i) for i in input().split(" ")]
list2 = [int(i) for i in input().split(" ")]
list3 = [int(i) for i in input().split(" ")]

print(sum(list1)-sum(list2))
print(sum(list2)-sum(list3))
