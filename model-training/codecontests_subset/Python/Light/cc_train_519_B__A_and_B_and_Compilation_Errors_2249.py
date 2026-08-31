n = int(input())
error_list1 = list(map(int , input().split(" ")))
error_list2 = list(map(int , input().split(" ")))
error_list3 = list(map(int , input().split(" ")))

error1 = sum(error_list1) - sum(error_list2)
error2 = sum(error_list2) - sum(error_list3)

print(error1)
print(error2)
