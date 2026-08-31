a, b = list(map(int, input().split()))
tot = a
rem = a
while(rem >= b):
    a = rem//b
    rem -= a*b
    tot+=a
    rem+=a
print(tot)