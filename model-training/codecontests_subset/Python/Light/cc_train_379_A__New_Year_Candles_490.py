a, b= map(int, input().split())
s, c= 0, 0
while a:
    s+= a
    c+= a%b
    a//= b
    if(not a and c>= b):
        a= c//b
        c%= b
print(s)