def polycarp(list):
    odd,even=[],[]
    for i in range(len(list)):
        if list[i]%2==0:
            even.append(list[i])
        else:
            odd.append(list[i])
    even.sort()
    odd.sort()
    sum=0
    if len(odd)>len(even)+1:
        for i in range(len(odd)-len(even)-1):
            sum+=odd[i]
    elif len(odd)<len(even)-1:
        for i in range(len(even)-len(odd)-1):
            sum+=even[i]
    else:
        sum=0
    return sum
n=int(input())
l=list(map(int,input().strip().split()))
print(polycarp(l))
