n = int(input())
a_lst = list(map(int, input().split(' ')))
b_lst = list(map(int, input().split(' ')))
c_lst = list(map(int, input().split(' ')))

a = sum(a_lst)
b = sum(b_lst)
c = sum(c_lst)

print(a - b)
print(b - c)