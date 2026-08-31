# https://codeforces.com/contest/1189/problem/A

strlen = int(input())  # string length
new_str = input()

# if string length is odd it cannot have same number of zeros and ones print direct
# what if string in even is still good 1110
# So count ones and zeros
count_zeros = new_str.count('0')
if strlen - count_zeros == strlen/2:  # even string, and ones == zeros,
    print(2)  # two string only
    print(new_str[0:strlen-1], end=" ")# breaking into odd it will print from 0 to strlen-2
    print(new_str[strlen-1])  # only one element seperated
else:
    print(1)  # one string only
    print(new_str)
