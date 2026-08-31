import re
n = int(input())
s = input()


count = [m.start() for m in re.finditer('8',s)]
print(min(len(count),n//11))