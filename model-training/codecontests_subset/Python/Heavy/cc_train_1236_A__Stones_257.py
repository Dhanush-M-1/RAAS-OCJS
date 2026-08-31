import math
if __name__ == '__main__':
    n = int(input())
    ans = list(range(n))
    for i in range(n):
        a = [int(x) for x in input().split(' ')]
        q = math.floor(a[2] / 2)
        ans[i] = 0
        if q >= a[1]:
            ans[i] = ans[i] + a[1] * 3
        elif q < a[1]:
            ans[i] = ans[i] + q*3
            a[1] = a[1] - q
            q1 = math.floor(a[1]/2)

            if q1 >= a[0]:
                ans[i] = ans[i] + a[0]*3
            else:
                ans[i] = ans[i] + q1 * 3
    for i in range(n):
        print(ans[i])