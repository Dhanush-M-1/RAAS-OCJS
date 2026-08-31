case=int(input())
while case!=0:
    n=int(input())
    a=list(map(int,input().split()))
    chk=False
    i=0
    for i in range(n-2):
        if a[i]+a[i+1]<=a[n-1]:
            print("1","2",n)
            chk=True
            break
    if chk==False:
        print("-1")
    case-=1
