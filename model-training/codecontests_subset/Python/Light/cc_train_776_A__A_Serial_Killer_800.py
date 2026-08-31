ini=input().split()
print (ini[0],ini[1])
for i in range(int(input())):
    s=input().split()
    if(s[0]==ini[0]):
        ini[0]=s[1]
    else:
        ini[1]=s[1]
    print (ini[0],ini[1])
