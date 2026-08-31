n=int(input())
odd=0
even=0
odd_min=[]
even_min=[]
s=list(map(int,input().split()))
for i in range(0,n):
    a=s[i]
    if (a&1)==1:
        odd+=1
        odd_min.append(a)
    else:
        even+=1
        even_min.append(a)
summ=0
if even - odd>=-1 and even - odd<=1:
    print(0)
else:
    if even>odd:
        even_min.sort()
        for i in range(0,even-odd-1):
            summ+=even_min[i]
    else:
        odd_min.sort()
        for i in range(0,odd-even-1):
            summ+=odd_min[i]
    print(summ)