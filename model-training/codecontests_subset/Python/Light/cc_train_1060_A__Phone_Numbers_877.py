n=int(input())
s=input()
k1=0
k2=0
if '8' in s and n>10:
    k1=s.count('8')
    k2=n//11
    print(min(k1,k2))
else:
    print(0)
