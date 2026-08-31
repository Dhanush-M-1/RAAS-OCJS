def fun(h,a,n):
    dic,dic2={},{}
    for i in h:
        if i not in set(dic.keys()):
            dic[i]=1
        else:
            dic[i]+=1
    for i in a:
        if i not in set(dic2.keys()):
            dic2[i]=1
        else:
            dic2[i]+=1
    l=set(dic.keys()).intersection(set(dic2.keys()))
    s=0
    for i in l:
        s+=dic[i]*dic2[i]
    print(s)
   



n=int(input())
h=list()
a=list()
for i in range(n):
        b,c=list(map(lambda x:int(x),input().split()))
        h.append(b)
        a.append(c)
fun(h,a,n)