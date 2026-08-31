import re
s=input()
d=re.findall(r'\d+',s)
a=int(d[0])
b=int(d[1])
hours=a
col=a
while (col%b)+(col//b)>=b:
    hours=hours+(col//b)
    col=(col//b)+(col%b)
hours=hours+(col//b)
print(hours)
