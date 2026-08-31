a = [int(x) for x in input().split()]
n = a[0] 
b = a[1];
t = n;
while(n >= b):
    n = n-b+1
    t = t+1;
print(t)