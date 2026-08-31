def set(n):
    #n = int(input())
    #if n == 0:
     #   return False
    lis = []
    for i in range(n):
        lis.append(len(input()))

    return lis

def solve(lis , n):
    ans = 0
    while ans < 5:
        ans += lis[n]
        n +=1
    #    print(n)
    if not(ans == 5):
        return False

    ans = 0
    while ans < 7:
        ans += lis[n]
        n +=1
   #     print(n)
    if not(ans == 7):
        return False


    ans = 0
    while ans < 5:
        ans += lis[n]
        n +=1
  #      print(n)
    if not(ans == 5):
        return False

    ans = 0
    while ans < 7:
        ans += lis[n]
        n +=1
 #       print(n)
    if not(ans == 7):
        return False

    ans = 0
    while ans < 7:
        ans += lis[n]
        n +=1
#        print(n)
    if not(ans == 7):
        return False
    return True

#main
while True:
    n = int(input())
    if not(n ==0):
        lis = set(n)
    for i in range(n):
        if solve(lis,i):
            print(i+1)
            break

        
    else:
        break

