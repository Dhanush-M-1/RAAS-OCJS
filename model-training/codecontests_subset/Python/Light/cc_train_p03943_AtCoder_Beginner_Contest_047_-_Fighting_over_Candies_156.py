a,b,c=map(int,input().split())
print(["No","Yes"][a+b+c==2*max(a,b,c)])