str1,str2 = map(str,input().split())
n = int(input()) 
print(str1,str2)
for each in range(n):
    murdered,replace = map(str,input().split()) 
    if(str1==murdered):
        str1 = replace
        print(str1,str2) 
    else:
        str2 = replace 
        print(str1,str2)
 
 