a,b=map(int,input().split())
output=a
left=a
while left>=b:
    output=output+(left//b)
    left=(left//b)+(left%b)
print(output)
