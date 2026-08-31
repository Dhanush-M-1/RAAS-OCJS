from sys import stdin , stdout
input = stdin.buffer.readline

t = int(input())

def main() :
    n = int(input())
    arr = list(map(int , input().split()))
    diff = maxval = 0 
    minval = 10**9
    allneg = True

    for i in range(n) :
        if arr[i] >= 0 :
            allneg = False

        if arr[i] == -1 :
            if i > 0 and arr[i - 1] >= 0 :
                maxval = max(maxval , arr[i - 1])
                minval = min(minval , arr[i - 1])

            if i < n - 1 and arr[i + 1] >= 0 :
                maxval = max(maxval , arr[i + 1])
                minval = min(minval , arr[i + 1])

        if i < n - 1 and arr[i] >= 0 and arr[i + 1] >= 0 :
            diff = max(diff , abs(arr[i] - arr[i + 1]))

    if allneg :
        return 0 , 0 
    
    avg = (maxval + minval) // 2
    return max(diff , abs(maxval - avg) , abs(minval - avg)) , avg 
    
for _ in range(t) :
    m , k = main()
    print(m , k)
    