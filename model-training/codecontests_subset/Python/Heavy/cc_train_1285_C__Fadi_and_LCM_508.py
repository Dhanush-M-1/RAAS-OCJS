from math import *
def gcd(a, b):
    c = 1
    a, b = max(a,b), min(a,b)
    while c != 0:
        c = a%b
        a,b = b,c
    return a
def find_min_of_max(lists):
    a = lists[0]
    b = lists[1]
    
def countCoprimePairs(n) :
    coprime_list = []
    maximum_list = []
    for i in range(2, int(sqrt(n)) + 1) :
        if n % i == 0 :
            if gcd(i, n // i) == 1 :
                coprime_list.append([i, n//i])
                maximum_list.append(max(i, n//i))
    if coprime_list == []:
        print("1 " + str(n))
        return
    min_index = min(enumerate(maximum_list),key=lambda x: x[1])[0]
    ans = coprime_list[min_index]
    print(str(ans[0]) + ' ' + str(ans[1]))

N = int(input())
countCoprimePairs(N)
