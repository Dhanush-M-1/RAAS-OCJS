from collections import Counter
n=int(input())
s=input()
f=s.count('8')
k=n//11
if f>=1 and k>=1:
    print(min(f,k))
else:
    print(0)
