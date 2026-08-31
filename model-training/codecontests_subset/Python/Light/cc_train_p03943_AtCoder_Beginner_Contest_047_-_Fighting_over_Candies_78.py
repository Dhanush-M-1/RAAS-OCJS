a,b,c=map(int,input().split())
print("Yes"if a+b==c or a+c==b or a==b+c else "No")