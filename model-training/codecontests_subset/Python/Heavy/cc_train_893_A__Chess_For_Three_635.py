a = []
for i in range(int(input())):
    a.append(int(input()))
s = 3
f = 1
if(len(a)==1):
    if(a[0]==s):
        print("NO")
    else:
        print("YES")
    exit(0)
for i in range(len(a)-1):
    w = a[i]
    if(i==0 and w==s):
        print("NO")
        f = 0
        break
    if(w==1 and s==3):
        s = 2
    elif(w==1 and s==2):
        s = 3
    elif(w==2 and s==3):
        s = 1
    elif(w==2 and s==1):
        s = 3
    elif(w==3 and s==1):
        s = 2
    elif(w==3 and s==2):
        s = 1
    if(a[i+1] == s):
        print("NO")
        f = 0
        break
if(f):
    print("YES")