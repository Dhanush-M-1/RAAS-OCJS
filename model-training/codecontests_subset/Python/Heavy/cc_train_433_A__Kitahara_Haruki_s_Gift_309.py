n=int(input())
if 1<= n <=100:
    w=[int(i) for i in input().split(" ")]
    no_of_100s = 0
    no_of_200s = 0
    for i in range(n):
        if(w[i] == 100):
            no_of_100s +=1
        if(w[i]== 200):
            no_of_200s +=1

    no_of_200s = no_of_200s%2 #Distribute half of them to either group.
    #print(no_of_200s)
    no_of_100s = no_of_100s - 2*no_of_200s #Balancing 100s based on 200s(1 or 0)
    #print(no_of_100s)
    if no_of_100s%2 == 0 and no_of_100s >= 0:#check remaining 100s can be divided in half.
        print("YES")
    else:
        print("NO")
