a,b=input().split()
a=int(a)
b=int(b)
count=a
while a//b>0:
      count+=(a//b)
      a=a//b+(a-((a//b)*b))
print(count)
