# link: https://codeforces.com/problemset/problem/519/B
if __name__ == "__main__":
    n = int(input())
    first = list(map(int, input().split()))
    first.sort()
    second = list(map(int, input().split()))
    second.sort()
    second.append(-1)
    for i in range(n):
        if first[i] != second[i]:
            print(first[i])
            break
    third = list(map(int, input().split())) 
    third.sort()
    third.append(-1)
    second.pop()
    for i in range(n-1):
        if second[i] != third[i]:
            print(second[i])
            break


