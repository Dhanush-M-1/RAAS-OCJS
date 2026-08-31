n,b = map(int,input().split())
count = n
while(n>=b):
    count+=n//b
    n=n//b+n%b
print(count)
