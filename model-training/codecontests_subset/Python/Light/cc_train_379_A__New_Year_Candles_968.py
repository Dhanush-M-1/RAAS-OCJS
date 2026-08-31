n=[int(i) for i in input().split(" ")]
a=n[0]
b=n[1]
count=0
while a>=b:
    a=a-b+1
    count+=b
count+=a
print(count)