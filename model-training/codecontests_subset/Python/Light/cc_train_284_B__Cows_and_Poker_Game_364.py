n=int(input())
arr=list(input())
if arr.count("I")==0:
    print(arr.count("A"))
elif arr.count("I")==1:
    print(1)
else:
    print(0)