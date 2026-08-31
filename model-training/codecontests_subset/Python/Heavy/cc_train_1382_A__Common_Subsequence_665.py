def get_first_common_element(x, y):
    ''' Fetches first element from x that is common for both lists
        or return None if no such an element is found.
    '''
    for i in x:
        if i in y:
            return i
    return None


t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    ans = get_first_common_element(a, b)
    if ans == None:
        print("NO")
    else:
        print("YES")
        print(1, ans)
