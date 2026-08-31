a,b,c = map(int,input().split())
print("Yes" if a+b == c or a+c ==b or c+b ==a else "No")