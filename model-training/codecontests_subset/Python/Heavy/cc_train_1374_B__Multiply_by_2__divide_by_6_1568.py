def countTwo(n):
    count=0
    while (n>1):
        if n%2==0: n=n//2; count+=1
        else: break
    return count
def countThree(n):
    count=0
    while (n>1):
        if n%3==0: n=n//3; count+=1
        else: break
    return count

for test in range(int(input())):
    n=int(input())
    if n==1: print (0)
    else:
        dictcount={2:countTwo(n),3:countThree(n)}
        # dictcount=dict(Counter(primefac))
        if (2**(dictcount[2])*3**(dictcount[3]))!=n: print (-1)
        else:
            if dictcount[2]>dictcount[3]:
                print (-1)
            else:
                print (2*dictcount[3]-dictcount[2])