x,y=map(int,input().split());a=list(map(int,input().split()))
print(min([y//i for i in a if y%i==0]))