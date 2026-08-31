a,b = [int(x) for x in input().split()]


sum = a

while(a>1):
    sum += a/b
    a = a/b
    
print(int(sum))