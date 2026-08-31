t=int(input())
suma=0
li = list(map(int,input().split()))
for i in range(t): 
    suma+=li[i]
li1 = list(map(int,input().split()))
sumb=0
for i in range(t-1): 
    sumb+=li1[i]
print(suma-sumb)
li2 = list(map(int,input().split()))
sumc=0
for i in range(t-2): 
    sumc+=li2[i]
print(sumb-sumc)
