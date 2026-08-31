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
        summ=sum(even[ind:])
    else:
        summ = sum(odd[ind:])

    #print("sdakh")
elif l2>l1+1:
    ind = l1+1
    summ=sum(even[ind:])
elif l1>l2+1:
    ind = l2+1
    #print("sdakh2")
    summ=sum(odd[ind:])

else:
    #print("sdakh")
    summ=0

print(summ)


#for x in range(n):
 #   y=int(input())
  #  l.append(y)