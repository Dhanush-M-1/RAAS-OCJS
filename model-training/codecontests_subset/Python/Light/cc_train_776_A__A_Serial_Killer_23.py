oria,orib=input().split()
print(oria,orib)
n=input()
for i in range(int(n)):
    kill,newm=input().split()
    if kill==oria:
        oria=newm
    else:
        orib=newm
    print(oria,orib)
