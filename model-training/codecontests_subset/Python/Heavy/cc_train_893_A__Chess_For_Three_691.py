n = int(input())
proshliyProigr = 0
b = True
for i in range(n):
    #print(i)
    s = int(input())
    if proshliyProigr == s:
        b = False
        #print("Da")
        break
    else:
        if i == 0:
            if s == 1:
                proshliyProigr = 2
            elif s == 2:
                proshliyProigr = 1
            else:
                b= False
                break
        else:
            if (s == 1 or proshliyProigr == 1) and (s == 2 or proshliyProigr == 2):
                proshliyProigr = 3
            elif (s == 2 or proshliyProigr == 2) and (s == 3 or proshliyProigr == 3):
                proshliyProigr = 1
            else:
                proshliyProigr = 2
if(b):
    print('YES')
else:
    print('NO')