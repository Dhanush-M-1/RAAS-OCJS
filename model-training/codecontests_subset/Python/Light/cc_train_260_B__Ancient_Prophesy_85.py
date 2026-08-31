from re import findall
from calendar import monthrange
from collections import defaultdict
n=input()
dic=defaultdict(int)
for i in findall('(?=(\d\d-\d\d-201[3-5]))',n):
    d,m,y=map(int,i.split('-'))
    if 1<=m<=12 and 1<=d<=monthrange(y,m)[1]:
        dic[i]+=1
print(max(dic,key=dic.get))