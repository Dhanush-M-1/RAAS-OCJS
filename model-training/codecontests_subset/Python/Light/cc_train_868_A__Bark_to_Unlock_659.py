pwd = str(input())
num = int(input())

f2 = b1 = False
done = False

for i in range(num):
    temp = str(input())
    if temp == pwd:
        done = True

    if temp[0] == pwd[1]:
        f2 = True
        
    if temp[1] == pwd[0]:
        b1 = True

    
if done == True:
    print("YES")
elif(f2 == True and b1 == True):
    print("YES")
else:
    print("NO")