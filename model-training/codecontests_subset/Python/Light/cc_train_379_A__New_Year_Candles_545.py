n,t = list(map(int,input().split(" ")))
i=n
while n >= t:
    i+=(n//t)
    n=(n//t)+(n%t)
print(i)