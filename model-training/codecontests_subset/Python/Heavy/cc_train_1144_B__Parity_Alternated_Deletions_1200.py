n=int(input())
a=list(map(int,input().split()))
odd=[]
even=[]
for i in a:
    if(i & 1):
        odd.append(i)
    else:
        even.append(i)
odd.sort()

even.sort()

if(abs(len(odd)-len(even))<2):
    ans=0
elif(len(odd)>len(even)):
    '''
    while(len(odd) ):
        odd.remove(odd[0])
        if(len(even)):
            even.remove(even[0])'''
    ans=sum(odd[:len(odd)-len(even)-1])
elif(len(odd)<len(even)):
    '''
    while(len(even)):
        even.remove(even[0])
        if(len(odd)):
            odd.remove(odd[0])'''
    ans=sum(even[:len(even)-len(odd)-1])
print(ans)