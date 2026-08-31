import itertools
def good(combo, k):
    alice = 0
    bob = 0
    for t,a,b in combo:
        if a == 1:
            alice += 1
        if b == 1:
            bob += 1
    return alice >= k and bob >= k

def brute(arr,k):
    result = float('inf')
    for comboSize in range(len(arr)-1, 0, -1):
        for combo in itertools.combinations(arr,comboSize):
            # print(combo)
            if good(combo,k):
                curr = sum(t for t,_,_ in combo)
                if curr < result:
                    result = curr
    if result == float('inf'):
        return -1
    return result

def fast(arr,k):
    anums = []
    bnums = []
    cnums = []
    for t,a,b in arr:
        if a == 1 and b == 0:
            anums.append(t)
        elif a == 0 and b == 1:
            bnums.append(t)
        elif a == 1 and b == 1:
            cnums.append(t)
    anums.sort()
    bnums.sort()
    cnums.sort()

    result = 0
    a,b,c = 0,0,0
    alice = 0
    bob = 0
    while alice < k and bob < k:

        if a<len(anums) and b<len(bnums):
            up1 = anums[a]+bnums[b]
        else:
            up1 = float('inf')
        if c<len(cnums):
            up2 = cnums[c]
        else:
            up2 = float('inf')
        
        if up1 == float('inf') and up2 == float('inf'):
            return -1

        if up1<up2:
            a+=1
            b+=1
            result += up1
        else:
            c+=1
            result += up2
        alice += 1
        bob += 1

    return result

def main():
    n,k = [int(x) for x in input().split()]
    arr = []
    for _ in range(n):
        t,a,b = [int(x) for x in input().split()]
        arr.append((t,a,b))
    
    #CHANGE
    # result = brute(arr,k)
    result = fast(arr, k)

    print(result)
    
main()