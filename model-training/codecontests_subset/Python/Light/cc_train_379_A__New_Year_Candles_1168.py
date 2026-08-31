a,b=input().split()
a,b=int(a),int(b)
s=a+a//b
while s<a+s//b:
    s=a+s//b
print(s)
