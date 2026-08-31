import re
import math

line = input()
p = re.compile("[\s]{1,}")
line = p.sub("$", line)

line = line.split("$")

a = int(line[0])
b = int(line[1])

count = 0
count += a

while a // b >= 1:
    t = 0
    t += a
    
    a //= b
    count += a
    
    a += t%b
    
print(count)
    
    

