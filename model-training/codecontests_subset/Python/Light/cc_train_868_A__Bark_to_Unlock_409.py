p=str(input())
n=int(input())

f=b=c=False  
for _ in range(n):
    s=str(input())
    if s==p: c=True; break 
    if s[1]==p[0]: f=True 
    if s[0]==p[1]: b=True 
    if (f and b): c=True; break 
if c==True: print("YES")
else: print("NO")


