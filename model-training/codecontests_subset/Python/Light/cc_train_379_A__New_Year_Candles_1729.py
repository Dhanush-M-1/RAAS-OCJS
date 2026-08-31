a,b=map(int,input().split())
count=a
while(a>=b):
    count+=int(a/b)
    a=int(a/b)+a%b
print(count)