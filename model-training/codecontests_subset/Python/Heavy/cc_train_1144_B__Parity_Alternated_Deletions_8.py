n=int(input())
arr=list(map(int,input().split()))
even=[]
odd=[]
while len(arr)>0:
    ele=arr.pop(0)
    if ele%2==0:
        even.append(ele)
    else:
        odd.append(ele)
if len(even)==len(odd):
    print(0)
elif len(even)>len(odd):
    diff=len(even)-len(odd)
    even.sort()
    ans=0
    for i in range(diff-1):
        ans+=even[i]
    if diff ==1:
        ans=0
    print(ans)
else:
    diff = -1*(len(even) - len(odd))
    odd.sort()
    ans = 0
    for i in range(diff-1):
        ans += odd[i]
    if diff ==1:
        ans=0
    print(ans)