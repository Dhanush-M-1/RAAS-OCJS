a,b=map(int,input().split())
num=a
i=a
while i>=b:
    num+=(i//b)
    i=i-(i//b)*(b-1)
print(num)
