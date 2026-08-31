Q = int(input())

for i in range(Q):
    arr = input()
    L,R,D = [int(x) for x in arr.split(' ')]
    
    if D<L:
        print(D)
    else:
        if R%D==0:
            print(R+D)
        else:
            print((R//D)*D+D)