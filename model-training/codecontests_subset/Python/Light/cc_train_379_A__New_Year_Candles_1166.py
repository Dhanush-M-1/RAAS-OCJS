a=input()
b=a.split()
count=0
c=int(b[0])
while int(b[1])<=c:
    count+=c - (c%int(b[1]))
    c=c//int(b[1]) + (c%int(b[1]))
else:
  count+=c

print(count)
