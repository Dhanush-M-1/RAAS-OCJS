input()

word1 = input()

"""
a       b      a      c      a      b      a
(a, 0) (a, 2) (a, 4) (a, 6) (b, 1) (b, 3) (c, 5)
"""

def str_reverse(word):
    idxed_word = [(letter, idx) for idx, letter in enumerate(word)]
    idxed_word.sort(key=lambda x: x[0])

    for idx, letter in enumerate(word):
        second_letter = idxed_word[idx][0]
        second_idx = idxed_word[idx][1]

        if letter > second_letter:
            print('YES')
            print(idx + 1, second_idx + 1)
            return

    print('NO')

str_reverse(word1)
