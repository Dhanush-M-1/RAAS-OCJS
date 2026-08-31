count1 = 0
count2 = 0
count3 = 0
s = input()
for i in range(len(s)):
    if s[i] == '1':
       count1 += 1
    elif s[i] == '2':
        count2 += 1
    elif s[i] == '3':
        count3 += 1
while(count1):
    if count1 != 0:
        count1-=1
        while(count1):
            print("1+",end='')
            count1-=1
        if count2 == 0 and count3 == 0:
            print("1")
        else:
            print("1+",end='')
while(count2):
    if count2 != 0:
        count2-=1
        while(count2):
            print("2+",end='')
            count2-=1
        if count3 == 0:
            print("2")
        else:
            print("2+",end='')
while(count3):
    if count3 != 0:
        count3-=1
        while(count3):
            print("3+",end='')
            count3-=1
        print("3")
   