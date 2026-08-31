a,b = map(int , input().split())
ans = a 
temp = a
left = a%b 
while temp>=b:
       ans += temp//b
       temp = temp//b + temp%b  
# while(       
print(ans)       