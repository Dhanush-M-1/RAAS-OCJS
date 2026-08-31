l = [i for i in input().split(' ')]
n , make = int(l[-1]) , int(l[-1])
 
positives = 1
negatives = 0
for i in l :
    if i == '-' :
        make += 1
        negatives += 1
    elif i == '+' :
        positives += 1
 
 
if make > n*positives or (make < positives and negatives == 0) :
    print('Impossible')
    exit(0)
 
ans = []
for i in range(n,0,-1) :
    while make >= i :
        ans.append(i)
        make-=i
    if make == 0 :
        break
 

idx = 0
while len(ans) > 0 and len(ans) < positives :
    if ans[idx] == 1 :
        idx+=1
    if idx > len(ans) or ans[idx] == 1 :
        break
    ans[idx]-=1
    ans.append(1)

idx = 0
negs = [0]*negatives
while len(ans) < positives :
    ans.append(1)
    negs[idx]+=1
    if negs[idx] == n :
        print('Impossible')
        exit(0)
    idx = (idx+1)%negatives
 
print('Possible')
print(ans[0],end=' ')
j,k = 0,1
for i in l :
    if i == '-' :
        print(i,1 + negs[j],end=' ')
        j+=1
    elif i == '+' :
        print(i,ans[k],end=' ')
        k+=1
    elif i != '?' :
        print(i,end=' ')
print()
