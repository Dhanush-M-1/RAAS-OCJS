from sys import stdin, stdout
 
#T = int(input())
 
#s = input()
N = int(input())

arr1 = [int(x) for x in stdin.readline().split()]
arr2 = list(arr1)

L = 0
for i in range(N):
    L = max(L,len(str(arr1[i])))


res = 0

for i in range(1,L+1):
    s = 0
    valid = 0
    remove = 0
    for j in range(N):
        num = arr1[j]
        if len(str(num))>=i:
            valid += 1
        if len(str(num))==i-1:
            remove += 1
            
    for j in range(N):
        num = arr1[j]
        if len(str(num))>=i:
            digit = int(str(num)[-i])
            A = 10
            B = 1
            s += valid*digit*11
    
    
    for j in range(N):
        num = arr2[j]
        res += 10**(2*i-2)*2*num*remove
        arr2[j] = arr2[j] // 10
        
    #print(valid,s,arr2,remove)
    res += 10**(2*i-2)*s
        
print(res%998244353)