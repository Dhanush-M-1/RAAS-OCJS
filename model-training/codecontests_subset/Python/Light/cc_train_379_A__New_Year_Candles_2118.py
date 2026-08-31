a,b=map(int,input().split())
s=a
while(a>b or a==b):
      s=s+int(a/b)
      a=int(a/b)+int(a%b)
print(s)    