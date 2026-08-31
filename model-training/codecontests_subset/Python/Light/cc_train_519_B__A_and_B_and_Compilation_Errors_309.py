z=int(input());I=lambda :list(map(int,input().split()))
lst1=I();lst2=I();lst3=I()
f1=lst1[0];f2=lst2[0]
lst1.remove(lst1[0])
for i in lst1+lst2:
    f1^=i
lst2.remove(lst2[0])
for i in lst2+lst3:
    f2^=i     
print(f1)
print(f2)
