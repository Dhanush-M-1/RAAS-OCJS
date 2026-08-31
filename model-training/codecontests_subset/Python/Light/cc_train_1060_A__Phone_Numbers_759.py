n=int(input())
ch=input()
dem=0
for i in ch:
    if i=='8':
        dem+=1
print (min(int(n/11),dem))