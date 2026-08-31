s=input().split(" ")
a,b=int(s[0]),int(s[1])
time=0
while a>=b:
    time+=b
    a=a-b+1
time+=a
print(time)