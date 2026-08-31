def solve(n):
    if n==1:
        return 0
    res = 0
    three = 0
    two = 0
    while n%6==0:
        res+=1
        n=n//6

    if n == 1:
        return res
    
    while n%3==0:
        three+=1
        n=n//3

    while n%2==0:
        two+=1
        n=n//2

    if n!=1:
        return -1
    if three>two:
        k = (three-two)*2
        return res+k

    return -1

# print(solve(6))
if __name__ == "__main__":
    test = int(input())
    for i in range(test):
        n = int(input())
        print(solve(n))