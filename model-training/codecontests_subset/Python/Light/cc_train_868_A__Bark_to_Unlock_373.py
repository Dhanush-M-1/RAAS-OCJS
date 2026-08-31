password = input()

n=int(input())
k=[]
for i in range(n):
    k.append(input())
    
def func(password,n,k):
    count1=0
    count2=0
    for i in range(n):
        if k[i]==password or k[i][::-1]==password:
            return "YES"
            
        if password[1]==k[i][0]:
            count1+=1
            
        elif password[0]==k[i][1]:
            count2+=1
            
    if count1>=1 and count2>=1:
        return "YES"
        
    return "NO"
    
print(func(password,n,k))