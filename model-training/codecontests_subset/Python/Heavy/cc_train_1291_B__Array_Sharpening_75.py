def solve(a):
    n = len(a)

    if n % 2 == 1:
        for i in range(n // 2):
            if a[i] < i:
                return "No"
        for i in range(n // 2, n):
            if a[i] < n - i - 1:
                return "No"
        return "Yes"
    else:
        ans = "Yes"
        for i in range(n // 2 + 1):
            if a[i] < i:
                ans = "No"
        for i in range(n // 2 + 1, n):
            if a[i] < n - i - 1:
                ans = "No"
        
        if ans == "Yes":
            return "Yes"

        for i in range(n // 2 - 1):
            if a[i] < i:
                return "No"
        for i in range(n // 2 - 1, n):
            if a[i] < n - i - 1:
                return "No"
        return "Yes"    

if __name__ == "__main__":
    t = int(input())
    for i in range(t):
        _ = input()
        a = list(map(int, input().split(' ')))
        print(solve(a))