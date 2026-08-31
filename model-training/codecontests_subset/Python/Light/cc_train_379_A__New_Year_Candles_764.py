a , b = map(int , input().split(' '))
res = a
rem = a
while(rem>=b):
    x = rem//b
    rem = rem%b+x
    res +=x
print(res)