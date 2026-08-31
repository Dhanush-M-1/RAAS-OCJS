#python3
a=int(input())
b=input()
c=list()
j=0
while j<a :
    d=int(b[j])
    c.append(d)
    j=j+1
m=int(a/11)
i=0
while m>0 :
    try:
        c.remove(8)
        i=i+1
    except:
        break
    m=m-1
print(i)
