n = int(input())
l=[int(x) for x in input().split()]
l=sorted(l, reverse=True)
#print(l)

even,odd=[],[]
for i in l:
    if i%2==0:
        even.append(i)
    else:
        odd.append(i)
summ=0
#print(odd,even)

l1=int(len(odd))
l2=int(len(even))

#print(l1,l2)
if (l1==0)|(l2==0):
    ind=1
    if l1==0:
        while 1:
            summ+=even[ind]
            ind+=1
            if ind==l2:
                break
    else:
        while 1:
            summ+=odd[ind]
            ind+=1
            if ind==l1:
                break

    #print("sdakh")
elif l2>l1+1:
    ind = l1+1
    #print("sdakh1")
    while 1:
        summ+= even[ind]
        ind+= 1
        if ind == l2:
            break
elif l1>l2+1:
    ind = l2+1
    #print("sdakh2")
    while 1:
        summ+= odd[ind]
        ind += 1
        if ind == l1:
            break

else:
    #print("sdakh")
    summ=0

print(summ)


#for x in range(n):
 #   y=int(input())
  #  l.append(y)