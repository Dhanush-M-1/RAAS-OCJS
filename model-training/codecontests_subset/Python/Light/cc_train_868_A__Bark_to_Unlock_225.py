s=input()
n=int(input())
ss=[]
for i in range(n):
    a=input()
    ss.append(a)
for i in range(n):
    for j in range(0,n):
        str=ss[i]+ss[j]
        str2=ss[j]+ss[i]
        #print(str,str2)
        if s in str or s in str2:
            print("yes")
            exit(0)

print("no")
    
    
