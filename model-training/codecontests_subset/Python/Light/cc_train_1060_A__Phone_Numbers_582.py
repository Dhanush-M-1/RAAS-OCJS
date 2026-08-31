n=int(input())
a=input()
cnt=a.count("8")
tot=0
if cnt==0 or n<11:
    print(0)
else:
    for i in range(cnt):
        if (n-1)//10>0:
            tot+=1
            n=n-11
        else:
            break
    print(tot)