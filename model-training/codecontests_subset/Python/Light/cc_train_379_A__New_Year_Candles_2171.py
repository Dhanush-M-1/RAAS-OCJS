a,b= list(map(int,input().split(" ")))
c=0
sum= a
while(a+c >= b):
    d= a
    a= (a+c)// b
    sum += a
    c= (d+c) % b
print(sum)
