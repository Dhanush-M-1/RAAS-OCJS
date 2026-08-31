def fre(l=[]):
    l.sort()
    temp={}
    cur =-1
    for i in l:
        if i==cur:
            temp[i]+=1
        else:
            temp[i]=1
            cur =i
    return temp

n =int(input())
f=fre(input().split(" "))
s=fre(input().split(" "))
t=fre(input().split(" "))
for i in f :
    if i in s :
        if f[i]==s[i]:
            continue
        else :
            print (i)
    else:
        print (i)

for i in s:
    if i in t :
        if s[i]==t[i]:
            continue
        else :
            print (i)
    else:
        print (i)


    
