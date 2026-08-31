n=int(input())
even=[]
odd=[]
inp=input()
inp=inp.split(' ')
for i in range(n):
    inp[i]=int(inp[i])
for ele in inp:
    if ele%2==0:
        even.append(ele)
    else:
        odd.append(ele)
odd.sort(reverse=True)
even.sort(reverse=True)
if(len(odd)>len(even)):
    ans=0
    num=len(even)+1
    for j in range(num,len(odd)):
        ans+=odd[j]
    print(ans)
elif len(even)>len(odd):
    ans=0
    num=len(odd)+1
    for j in range(num,len(even)):
        ans+=even[j]
    print(ans)
else:
    ans=0
    print(ans)
