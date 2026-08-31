
n = int(input())
s = str(input())

count = 0
for i in range(n):
    if s[i] == '8':
        count+=1

if count == 0:
    print(0)

elif  n // 11  <= count:
    print(n // 11 )
else:
    print(count)