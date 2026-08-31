def prefix(arr):
  for i in range(1, len(arr)):
    arr[i] += arr[i - 1]
  return arr
t=int(input())
for q in range(t):
    l,m=map(int,input().split())
    s=input()
    ar = list(map(int, input().split()))
    arr=[0]*len(s)

    for i in range(len(ar)):
        arr[0] += 1
        arr[min(ar[i], len(arr) - 1)] += -1
    arr[0]+=1
    prefix(arr)
    #print(arr)
    hash=[0]*26
    for i in range(len(s)):
        hash[ord(s[i])-ord('a')]+=arr[i]
    for i in range(len(hash)):
        print(hash[i],end=' ')
    print()





