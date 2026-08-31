a=int(input())
b=str(input())
c=a//11
if b.find("8")!=-1:
    d=b.count("8")
else:
    d=0
print(min(c,d) if a>=11 else 0)