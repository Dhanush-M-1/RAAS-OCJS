old,b=map(int,input().split())
hour=old
while old>=b:
    new=old//b
    hour+=new
    left=old%b
    old=new+left
print(hour)