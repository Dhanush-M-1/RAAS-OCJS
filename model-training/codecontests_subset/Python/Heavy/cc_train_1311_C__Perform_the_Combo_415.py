input = __import__('sys').stdin.readline
print = __import__('sys').stdout.write

for _ in range(int(input())):
    n, k = map(int, input().split())
    alpha = [0 for _ in range(26)]
    word = input()
    word_ss = [1 for _ in range(n)]
    kk = [0] + sorted(list(map(int, input().split())))
    # print(str(kk) + '\n')
    for idx, idx2  in enumerate(range(k, 0, -1), 1):

        if word_ss[kk[idx] - 1] == 1:
            for j in range(kk[idx-1], kk[idx]):
                word_ss[j] += idx2
        # print(str(word_ss) + '\n')

    for i in range(n):
        alpha[ord(word[i]) - 97] += word_ss[i]

    for w in alpha:
        print(f'{w} ')
    print('\n')
# codeforces
#
# 9976666
# 553222210
#
# 2 2 3 8 9