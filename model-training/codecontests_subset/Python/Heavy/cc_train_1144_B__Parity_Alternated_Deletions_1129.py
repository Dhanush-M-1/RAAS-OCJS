# cook your dish here
t=int(input())
a=[int(i) for i in input().split()]
a.sort()
even=[]
odd=[]
for i in a:
    if i%2==0:
        even.append(i)
    else:
        odd.append(i)
if len(even)==len(odd):
    print(0)
else:
        if len(even)>len(odd):
            while(len(odd)!=0):
                even.pop()
                odd.pop()
            even.pop()
            print(sum(even))
        else:
            while(len(even)!=0):
                odd.pop()
                even.pop()
            odd.pop()
            print(sum(odd))