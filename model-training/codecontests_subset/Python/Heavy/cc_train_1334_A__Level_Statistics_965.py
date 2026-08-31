# https://codeforces.com/problemset/problem/266/A
def statsLevel(res_in):

    if len(res_in) == 0:
        return 'NO'

    if res_in[0][0] < res_in[0][1]:
        return 'NO'

    for i in range(1, len(res_in)):

        if res_in[i - 1][0] > res_in[i][0]:
            return 'NO'
        if res_in[i - 1][1] > res_in[i][1]:
            return 'NO'
        if res_in[i][1] - res_in[i - 1][1] > res_in[i][0] - res_in[i - 1][0] :
            return 'NO'

    return 'YES'



def main():

    T = int(input())

    for i in range(T):
        res_ans = []
        n = int(input())
        res_in = []
        inn = []
        for i in range(n):
            flats = input()
            inn = [int(lt) for lt in flats.split(' ')]
            res_in.append(inn)

        res_ans.append(statsLevel(res_in))

        for i in res_ans:
            print(i)


if __name__ == "__main__":
    main()