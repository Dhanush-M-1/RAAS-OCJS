# https://codeforces.com/contest/1155/problem/A

# Turn input word into list of characters
length = input()
entry_list = list(input())
sorted_entry_list = entry_list.copy()
sorted_entry_list.sort()

# If characters are already in order, print NO
if sorted_entry_list == entry_list:
    print('NO')

# Otherwise, find the first place where the actual list deviates
else:
    position = 0
    while 1 == 1:
        if sorted_entry_list[position] == entry_list[position]:
            position += 1
        else:
            break

# Then find the next spot in the string that's less than that item. Print indices.
    n = position + 1
    solution_found = 'NO'
    while 1 == 1:
        if entry_list[n] < entry_list[position]:
            print('YES')
            print((position + 1), (n + 1))
            break
        else:
            n += 1

