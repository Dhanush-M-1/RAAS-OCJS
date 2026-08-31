s=["Even","Even","Odd"]
print(s[sum(map(lambda x: int(x)%2,input().split()))])