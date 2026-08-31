# A string is considered good string if the occurrence
# of '0' & '1' is different. So if the length of string
# is odd, then we already get good string. When the length
# is even, there are 2 cases:
#
# 1. the occurrence of '0' & '1' is different
# 2. the occurrence of '0' & '1' is same
#
# In first case, we already got the good string, so we doesn't
# need to break the string.
#
# In second case, we just need to break the string into odd length
# (since we already know string with odd length is good string),
# to do that we just need to break the string into two, the first
# substring is having length 1 & the second substring would have
# odd length.

n = int(input())
s = input()

if (n % 2) == 1:
    print(f'1\n{s}')
else:
    if s.count('0') != s.count('1'):
        print(f'1\n{s}')
    else:
        print(f'2\n{s[:1]} {s[1:]}')
