from sys import stdin, stdout
a,b=map(int,stdin.readline().split())
h=a
s=0
while(a>=b):
  h+=(a//b)
  s=a%b
  a=a//b+s
  
print(h)
       

