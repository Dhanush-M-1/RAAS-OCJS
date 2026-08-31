from collections import Counter
n=int(input())
a=list(int(x) for x in input().split())
b=list(int(x) for x in input().split())
c=list(int(x) for x in input().split())
a_c=Counter(a)
b_c=Counter(b)
c_c=Counter(c)
for key,val in a_c.items():
    if key not in b_c or abs(val-b_c[key])==1:
        print(key)
        break
for key,val in b_c.items():
    if key not in c_c or abs(val-c_c[key])==1:
        print(key)
        break