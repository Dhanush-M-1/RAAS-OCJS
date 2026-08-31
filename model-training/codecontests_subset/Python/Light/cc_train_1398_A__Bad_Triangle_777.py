for T in range(int(input())):
    n = int(input())
    l= list(map(int,input().split()))
    a1 = l[0]
    a2 = l[1]
    a3 = l[-1]
    if(a1+a2 <= a3):
        print(str(1)+" "+str(2)+" "+str(n))
    else:
        print(-1)
