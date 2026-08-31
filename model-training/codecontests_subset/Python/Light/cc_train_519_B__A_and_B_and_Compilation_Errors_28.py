a = int(input())
lst_1 = list(map(int, input().split()))
lst_2 = list(map(int, input().split()))
lst_3 = list(map(int, input().split()))

first_mistake = sum(lst_1) - sum(lst_2)
second_mistake = sum(lst_2) - sum(lst_3)
print(first_mistake, '\n', second_mistake)