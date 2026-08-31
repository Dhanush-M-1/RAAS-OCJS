n,k = map(int,input().split(" "))
a = list(map(int,input().split(" ")))
a.sort()
min_hr = 100000000000000000000
for char in a:
    if(k%char==0 and min_hr>k/char):
        min_hr = int(k/char)
print(min_hr)
    
    
