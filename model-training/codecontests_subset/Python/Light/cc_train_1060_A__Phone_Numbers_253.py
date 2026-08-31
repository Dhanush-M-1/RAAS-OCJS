n= int(input())
s= input()
count8=0
for i in s:
    if i=='8':
        count8+=1

if count8==0:
    print('0')
else:
    print(min(count8, n//11))
