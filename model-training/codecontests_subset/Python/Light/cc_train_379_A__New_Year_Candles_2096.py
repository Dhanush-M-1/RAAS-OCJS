a,b=input().split()
a,b=int(a),int(b)
result=a
while((a//b)!=0):
 result=result+a//b
 a=a//b+a%b
print(result)