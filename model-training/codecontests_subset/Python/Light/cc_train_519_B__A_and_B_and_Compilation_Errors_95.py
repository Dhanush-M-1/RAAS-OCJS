#A abd B compilation
n=int(input())
first=list(map(int,input().split(" ")))[:n]
second=list(map(int,input().split(" ")))[:n-1]
third=list(map(int,input().split(" ")))[:n-2]
first.sort()
second.sort()
third.sort()
i=0
while(i<len(second)):
    if(first[i]!=second[i]):
        print(first[i])
        break
    i+=1
if i==len(second):
    print(first[-1])
i=0
while(i<len(third)):
    if(third[i]!=second[i]):
        print(second[i])
        break
    i+=1
if i==len(third):
    print(second[-1])