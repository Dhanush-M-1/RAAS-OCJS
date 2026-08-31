n=int(input())
s = input()
l=[]
for i in range(len(s)):
    l.append(int(s[i]))
#print(l)
cnt = l.count(8)
dcnt = int(n/11)
#print(cnt,dcnt)
if(dcnt==0 or cnt==0):
    print(0)
elif(dcnt!=0 and cnt!=0):
    print(min(dcnt,cnt))
elif(dcnt==0 and cnt!=0):
    print(0)
else:
    print(0)

