# http://codeforces.com/contest/1144/problem



# A diverse_strings
# n = int(input())
# array = []
# alphabet = "abcdefghijklmnopqrstuvwxyz"
# for i in range(n):
#     array.append(input())
# for i in array:
#     var = 1
#     a = sorted(i)
#     start = alphabet.index(a[0])
#     if len(a) <= 26:
#         for i in range (len(a)):
#             if a[i] != alphabet[i + start]:
#                 var = 0
#                 break
#     else:
#         var = 0
#     if var == 1:
#         print("yes")
#     else:
#         print("no")



# B parity alternated deletion
n = int(input())
array = list(map(int, input().split()))
array = sorted(array)
even = []
odd = []
sum = 0
for i in array:
    if i % 2 == 0:
        even.append(i)
    else:
        odd.append(i)
if len(even) > len(odd):
    for i in range(len(even) - len(odd) - 1):
        sum += even[i]
    print(sum)
elif len(even) < len(odd):
    for i in range(len(odd) - len(even) - 1):
        sum += odd[i]
    print(sum)
else:
    print("0")

