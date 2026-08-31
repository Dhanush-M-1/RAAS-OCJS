def kek():
    n = int(input())
    arr1 = []
    arr2 = []
    
    for i in range(n):
        p, c = [int(j) for j in input().split()]
        arr1.append(p)
        arr2.append(c)
 
    for i in range(n):
        if arr2[i] > arr1[i] or i > 0 and arr1[i] < arr1[i - 1] or i > 0 and arr2[i] < arr2[i - 1]:
            print('NO')
            return;
        if i > 0:
            r = arr2[i] - arr2[i-1]
            if arr1[i] - arr1[i-1] < r:
                print('NO')
                return;
    print('YES')
 
 
def main():
    t = int(input())
 
    for i in range(t):
        kek()
 
main()