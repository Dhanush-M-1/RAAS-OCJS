n=int(input())
##x=dict()
##y=dict()
l = [int(s) for s in input().split()]
##for i in data1:
##    x[i]=data1.count(i)
dicts=dict()
for el in l:
    if el in dicts.keys():
        dicts[el]+=1
    else:
        dicts[el]=1
l = [int(s) for s in input().split()]
dictssec={}
for el in l:
    if dicts[el]>1:
        dicts[el]-=1
    else:
        del(dicts[el])
    if el in dictssec.keys():
        dictssec[el]+=1
    else:
        dictssec[el]=1
l = [int(s) for s in input().split()]
h=list(dicts.keys())
print(h[0])
for el in l:
    if dictssec[el]>1:
        dictssec[el]-=1
    else:
        del(dictssec[el])
h=list(dictssec.keys())
print(h[0])
##for i in data2:
##    x[i]-=1
##for i in x.keys():
##    if(x[i]>0):
##        for j in range(x[i]):
##            print(i)
##for i in data2:
##    data1.remove(i)
##print(data1[0])
##for i in data3:
##    data2.remove(i)
##print(data2[0])
