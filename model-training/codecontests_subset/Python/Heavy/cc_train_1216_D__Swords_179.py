import math
p = 0
s = 0
def delete(li,m) :
    li2 = []
    for i in range(len(li)) :
        if li[i] != m :
            li2.append(li[i])
    return li2
def gcdf(li,m) :
    gcd = math.gcd(m-li[0],m-li[1])
    for i in range(len(li)-2) :
        gcd = math.gcd(gcd,m-li[i+2])
    return gcd
t = int(input())
li = list(map(int,input().split()))
sum = sum(li)
max = max(li)
li = delete(li,max)
if len(li) == 0 :
    p = 0
    s = 0
elif len(li) == 1 :
    p=1
    s = max - li[0]
else :
    s = gcdf(li,max)
    n = t* max
    p = (n - sum)/s
print(int(p),int(s))