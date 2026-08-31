n= int(input())
li=list(map(int, input().split()))
if len(li)==1:
    print(li[0])
else:
    odd=[i for i in li if i%2!=0]
    even=[i for i in li if i%2==0]
    if len(li)==2:
        if len(even)==2 or len(odd)==2:
            print(min(li[0] , li[1]))
    else:
        if len(even)==len(odd):
            print(0)
        elif len(even)+1==len(odd):
            print(0)
        elif len(even)-1==len(odd):
            print(0)
        else:
            odd.sort()
            even.sort()
            if len(odd)>len(even):
                x=len(odd)-len(even)-1
                odd=odd[:x]
                print(sum(odd))
            else:
                x=len(even)-len(odd)-1
                even=even[:x]
                print(sum(even))