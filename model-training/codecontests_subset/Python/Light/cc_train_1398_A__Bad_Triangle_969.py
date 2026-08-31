def main():
    t = int(input())
    for i in range(t):
        solve()

def solve():
    n = int(input())
    array = tuple(map(lambda x: int(x), input().split()))

    # the sum of smaller two sides should be greater than the largest side

    lowestSum = array[0] + array[1]

    if array[n-1] < lowestSum: # all the next elements are lower too
        print(-1)
    else: # not lower than sum -> impossible
        print(1, 2, n)

main()
