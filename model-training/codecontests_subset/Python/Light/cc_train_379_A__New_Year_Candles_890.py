a,b = map(int,input().split())
count = a

while(a//b!=0):
    c = a//b
    a = c+a%b
    count= count+c
print(count)
