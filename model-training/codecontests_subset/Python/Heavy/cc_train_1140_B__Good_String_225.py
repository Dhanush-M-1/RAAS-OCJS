def Solve(s,n):
    if s[0] == '>' or s[-1] == '<':
        print(0)
        return
    count = 0
    min_count = float('inf')
    for i in range(n):
        if s[i] == '<':
            count += 1
        else:
            min_count = count
            break

    count = 0
    for i in range(n-1,-1,-1):
        if s[i] == '>':
            count += 1
        else:
            break

    print(min(count,min_count))
    
def main():
    t = int(input())
    for i in range(t):
        n = int(input())
        s = input()
        Solve(s,n)
                

main()
