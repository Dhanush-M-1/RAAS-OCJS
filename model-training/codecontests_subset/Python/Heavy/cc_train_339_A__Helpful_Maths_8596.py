def insertion_sort_increase(lst):
    for i in range(1, len(lst)):
        x = lst[i]
        j = i
        result = 0
        while j > 0 and result == 0:
            if lst[j - 1] > x:
                lst[j] = lst[j - 1]
                j -= 1
            else:
                result = j
        lst[result] = x
    return lst
#main
s = input()
i = 0
lst = []
while i < len(s):
    lst.append(s[i])
    i+=2
insertion_sort_increase(lst)
for i in range(len(lst)):
    if i != len(lst)-1:
        print(lst[i],end='')
        print('+',end='')
    else:
        print(lst[i],end='')