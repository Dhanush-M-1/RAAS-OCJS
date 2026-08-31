t=int(input())
for i in range(t):
    n=int(input())
    s=input()
    l=s.split()
    lst=[]
    for i in range(len(l)):
        lst.append(int(l[i]))
    if(lst[0]+lst[1]<=lst[n-1]):
        print("1 2",n)
    else:
        print("-1")
