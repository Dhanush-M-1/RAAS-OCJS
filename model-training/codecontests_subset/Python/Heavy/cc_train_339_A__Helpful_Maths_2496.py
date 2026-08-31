from sys import stdin

# 65-90 A   97-122 a

A = stdin.readline()
B = len(A)

# 0 ,2 , 4

k=0
count1=0
count2=0
count3=0

while k<=B-1:
    if A[k]=='1':
        count1+=1
    elif A[k]=='2':
        count2+=1
    else:
        count3+=1
    k+=2

U=count1+count2+count3
ans=''
for u in range(0,count1):
    if u==U-1:
        ans+='1'
    else:
        ans+='1+'

for v in range(0,count2):
    if count1+v==U-1:
        ans+='2'
    else:
        ans+='2+'

for w in range(0,count3):

    if w==count3-1:
        ans+='3'
    else:
        ans+='3+'

print(ans)