n=int(input())
arr=list(map(int,input().strip().split(' ')))
arr.sort()
freq=[0]*(10**6+1)
for i in arr:
  freq[i]=1
p=1
q=10**6
cnt=0
for i in range(1,10**6+1):
  if(freq[p+i]==1):
    cnt+=1
  if(freq[q-i]==1):
    cnt+=1
  if(cnt>=n):
    break
print(i)