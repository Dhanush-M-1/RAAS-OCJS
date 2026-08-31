n = int(input())
count = 0
str = input()

for i in range(0,len(str),1):
    if str[i] == '8':
        count += 1

if(int(n/11) <= count):
    print(int(n/11))
elif(count == 0):
    print(0)
elif(count < int(n/11)):
    print(count)