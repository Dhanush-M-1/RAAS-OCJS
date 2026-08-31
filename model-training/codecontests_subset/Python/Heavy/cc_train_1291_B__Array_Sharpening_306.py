def solution(n, a):
    left, right = 0, 0
    for i, x in enumerate(a):
        left = i
        if i > x:   break
        if i == n - 1:  return 'Yes'

    for i, x in enumerate(a[::-1]):
        right = i 
        if i > x:   break
        if i == n - 1:  return 'Yes'

    if left + right <= n:
        return 'No'
    else:
        return 'Yes'

if __name__ == "__main__":
    t = int(input())    

    for _ in range(t):
        n = int(input())
        a = list(map(int, input().split(' ')))
        print(solution(n, a))
