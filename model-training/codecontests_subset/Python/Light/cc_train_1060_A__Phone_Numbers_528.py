"""
    Phone Numbers
"""
n = int(input())
nString = input()
eights = nString.count('8')
strings = n //11
print(strings if(strings <= eights) else eights)