pas = input()

n = int(input())

words = []

for i in range(n):
    words.append(input())
    

for i in words:
    if(i == pas or i == pas[::-1]):
        print("YES")
        quit()


count1 = 0
count2 = 0

for i in words:
    if(i[0] == pas[1]):
        count1 = count1 + 1
    if(i[1] == pas[0]):
        count2 += 1
        
if(count1 >= 1 and count2 >= 1):
    print("YES")
else:
    print("NO")