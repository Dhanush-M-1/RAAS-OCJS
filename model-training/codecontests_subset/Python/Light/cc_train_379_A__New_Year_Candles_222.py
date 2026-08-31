a,b = (int(i) for i in input().split())
s = 0
s1 = a
s2 = 0
while (a>0):
    s+=1
    a-=1
    if (a==0):
        s2 = s1%b
        s1 //=b
        a+=s1
        s1 = a + s2
print(s)