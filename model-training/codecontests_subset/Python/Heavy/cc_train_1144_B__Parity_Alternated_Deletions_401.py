#wrong
n = int(input())
a = sorted(list(map(int, input().split(" "))), reverse = True)
even = [x for x in a if x%2 == 0]
odd = [y for y in a if y%2 != 0]
if abs(len(even) - len(odd)) == 1:
    print(0)
elif len(even) == len(odd):
    print(0)
else:
    if len(even) > len(odd):
        even = even[::-1]
        l = len(even) - len(odd)
        even = even[:l-1]
        print(sum(even))
    elif len(odd) > len(even):
        odd = odd[::-1]
        l = len(odd) - len(even)
        odd =odd[:l-1]
        print(sum(odd))


# a = a[::-1]
# if n == 1:
#     print(a)
# else:
#     flag = 0
#     i = 0
#     while i < n-1:
#         if a[i]%2 == 0 and flag == 0:
#             a.pop(i)
#             flag = 1
#         elif i%2 != 0 and flag == 1:
#             a.pop(i)
#             flag = 0
#         i += 1
# print(sum(a))    
