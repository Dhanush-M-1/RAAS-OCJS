x=input() 
p=0;
q=0;
for _ in range (int(input())) :
    n = input()
    if n==x or n==x[::-1] :
        exit(print("YES"))
    if n[1]==x[0] :
        p=1
    if n[0]==x[1] :
        q=1
    if p and q :
        exit(print("YES"))
if p and q :
    print("YES")
else :
    print("NO")