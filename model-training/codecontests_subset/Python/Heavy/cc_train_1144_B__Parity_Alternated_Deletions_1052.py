k=int(input())
A=sorted([int(x) for x in input().split()])
odd_c=0
evn_c=0
odd_a=[]
even_a=[]
big_even=0
big_odd=0
for s in range(k):
    if(A[s]%2==0):
        evn_c+=1
        if(A[s]>big_even):
            big_even=A[s]
        even_a.append(A[s])
    else:
        odd_c+=1
        if(A[s]>big_odd):
            big_odd=A[s]
        odd_a.append(A[s])
if(odd_c==evn_c):
    print(0)
elif(odd_c==evn_c+1 or evn_c==odd_c+1):
    if(odd_c!=0 and evn_c!=0):
        print(0)
    else:
        if(odd_c==0):
            print(sum(A)-big_even)
        else:
            print(sum(A)-big_odd)
else:
    W=min(odd_c,evn_c)
    Z=0
    if(W==odd_c):
        Z+=sum(even_a[:evn_c-W-1])
        print(Z)
    else:
        print(sum(odd_a[:odd_c-W-1]))
        
                  
                  
