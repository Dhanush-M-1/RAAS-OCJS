number=input()
values=list(map(int,input().split(" ")))
odd=[]
even=[]
for i in values:
        if i %2==0:
                even.append(i)
        else:
                odd.append(i)
if len(sorted(odd))==len(sorted(even)):
        print(0)
elif len(sorted(odd))-len(sorted(even))==-1 or len(sorted(odd))-len(sorted(even))==1:
        print(0)
elif len(sorted(odd))>len(sorted(even)):
        sum=0
        for i in range(len(sorted(odd))-len(sorted(even))-1):
                sum=sum+sorted(odd)[i]
        print(sum)
elif len(sorted(even))>len(sorted(odd)):
        sum=0
        for i in range(len(sorted(even))-len(sorted(odd))-1):
                sum=sum+sorted(even)[i]
        print(sum)
