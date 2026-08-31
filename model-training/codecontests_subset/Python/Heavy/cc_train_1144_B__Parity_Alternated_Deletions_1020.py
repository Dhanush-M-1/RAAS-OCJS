n=int(input())
m=list(map(int,input().split()))
even=[]
odd=[]
lodd=0
leven=0
for i in m:
     if i%2:
          even.append(i)
          leven+=1
     else:
          odd.append(i)
          lodd+=1
#print(odd,even,leven,lodd)
if abs(leven-lodd)<2:
     print(0)
     exit()
else:
     even.sort()
     odd.sort()
     if lodd-min(lodd,leven)-1==-1:
          kk=0
     else:
          kk=lodd-min(lodd,leven)-1
     if leven-min(lodd,leven)-1==-1:
          kkk=0
     else:
          kkk=leven-min(lodd,leven)-1
     print(sum(odd[0:kk])+sum(even[0:kkk]))