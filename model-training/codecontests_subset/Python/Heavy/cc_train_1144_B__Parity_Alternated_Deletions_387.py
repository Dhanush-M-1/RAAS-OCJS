
def calc(n,a):
    even=[]
    odd=[]
    for i in a:
        if i%2==0:
            even.append(i)
        else:
            odd.append(i)
    even.sort(reverse=True)
    odd.sort(reverse=True)
    # print(odd)
    # print(even)
    if len(even)==0:
        print(sum(odd[1:]))
    elif len(odd)==0:
        print(sum(even[1:]))
    else:
        if len(odd)<len(even):
            print(sum(even[len(odd)+1:]))
        elif len(odd)>len(even):
            print(sum(odd[len(even)+1:]))
        else:
            print(0)



n=int(input())
a=list(map(int,input().split()))
calc(n,a)