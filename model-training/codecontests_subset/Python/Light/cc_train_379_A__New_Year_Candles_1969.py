n,b = map(int,input().split())
res = n
while n//b: 
    res += n//b
    a = n%b
    n//=b; n+=a
print(res) 