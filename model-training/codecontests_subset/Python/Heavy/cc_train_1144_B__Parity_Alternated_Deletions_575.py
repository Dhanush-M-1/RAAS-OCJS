n = int(input())
array = input()
A = [int(x) for x in array.split()]

odd_list = []
even_list = []

odd_counter = 0
even_counter = 0


for x in A:
    if x % 2 == 0:
        even_list.append(x)
        even_counter += 1
    else:
        odd_list.append(x)
        odd_counter += 1


if even_counter > odd_counter + 1:
    even_list.sort()
    dif = even_counter- odd_counter -1
    ans = sum(even_list[:dif])
elif odd_counter > even_counter + 1:
    odd_list.sort()
    dif = odd_counter - even_counter -1
    ans = sum(odd_list[:dif])
else:
    ans = 0

print(ans)