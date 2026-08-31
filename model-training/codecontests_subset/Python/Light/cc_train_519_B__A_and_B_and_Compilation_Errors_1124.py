from collections import defaultdict
n=int(input())
arr1=list(map(int,input().split()))
arr2=list(map(int,input().split()))
arr3=list(map(int,input().split()))
myMap1=defaultdict(int)
myMap2=defaultdict(int)
myMap3=defaultdict(int)
for val in arr1:
    myMap1[val]+=1
for val in arr2:
    myMap2[val]+=1
for val in arr3:
    myMap3[val]+=1
for val in myMap1:
    if myMap2[val]!=myMap1[val]:
        print(val)
        break
for val in myMap2:
    if myMap3[val]!=myMap2[val]:
        print(val)
        break