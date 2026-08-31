a,b = map(int,input().split())
copy_of_a = a
while a//b > 0:
    c = a//b
    copy_of_a += c
    a = c + a%b
print(copy_of_a)