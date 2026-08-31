'''def Diff(li1, li2): 
    return (list(set(li1) - set(li2))) '''
'''def Diff(li1, li2): 
     li_dif = [i for i in li1 + li2 if i not in li1 or i not in li2] 
     return li_dif''' 
n=int(input())
l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))
l1.sort()
l2.sort()
l3.sort()
for i in range(len(l2)):
	if(l1[i]!=l2[i]):
		a1=l1[i]
		break
	else:
		a1=l1[-1]
for i in range(len(l3)):
	if(l3[i]!=l2[i]):
		a2=l2[i]
		break
	else:
		a2=l2[-1]
print(a1)
print(a2)

