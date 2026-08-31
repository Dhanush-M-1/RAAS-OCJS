def solve(n,c,arr):
    max_diff = 0
    for i in range(n-1):
        diff = arr[i] - arr[i+1]
        if diff > max_diff:
            max_diff = diff
    return max(0, max_diff - c)





        


def main():
    n,c = list(map(int, input().split(" ")))
    arr = list(map(int, input().split(" ")))
    # t = input()

    # s = input()
    # a = list(map(int, input().split(" ")))
    # b = list(map(int, input().split(" ")))
    # c = list(map(int, input().split(" ")))
    # res = []
    # for _ in range(n):
    #    arr = list(map(int, input().split(" ")))
    #    res.append(arr)
    print(solve(n,c,arr))
    # i = 0
    # inputpath = 'input.txt'
    # outPath = 'output.txt'
    # with open(inputpath) as fp:
    #     line = fp.readline()
    #     cnt = 1
    #     while line:
    #         if cnt == 1:
    #             i = int(line)
    #         else:
    #            arr = list(map(int, line.split(" ")))
    #            res.append(arr)  
    #         cnt += 1
    #         line = fp.readline()
    # s = solve(res,i)
    # with open(outPath, 'a') as out:
    #     out.write(str(s))


main()