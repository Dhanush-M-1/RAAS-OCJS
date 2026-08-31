
n=int(input())
arr=list(map(int,input().split()))

even=[]
odd=[]

for i in arr:
    if(i%2==0):
        even.append(i)
    else:
        odd.append(i)

even.sort(reverse=True)
odd.sort(reverse=True)


if(len(even)==len(odd)):
    print(0)
elif(len(even)>len(odd)):
    ans=0
    if(len(even)-(len(odd)+1)==0):
        print(ans)
    else:
        ind=len(even)-(len(odd)+1)
        for i in range(1,ind+1):
            ans=ans+even[-i]

        print(ans)
else:
    ans=0
    if(len(odd)-(len(even)+1)==0):
        print(ans)
    else:
        ind=len(odd)-(len(even)+1)
        for i in range(1,ind+1):
            ans=ans+odd[-i]

        print(ans)
