# Here char is a synonym for sym.

from collections import Counter

for _ in range(int(input())):
    s, c = input().split()
    s = [i for i in s]
    c = [i for i in c]

    if s < c:
        print(''.join(s))
    else:
        characters_of_the_s = Counter(s)
        # print(characters_of_the_s)
        flag = 0
        for ind, characters in enumerate(zip(s, c)):
            char_of_the_s, char_of_the_c = characters

            characters_of_the_s[char_of_the_s] -= 1
            if characters_of_the_s[char_of_the_s] == 0:
                del characters_of_the_s[char_of_the_s]

            for sym in characters_of_the_s:
                if sym < char_of_the_c:
                    # print(ind, sym, char_of_the_c)
                    index_to_replace = ind
                    substitute = sym
                    flag = 1

            if flag == 1:
                break

            if char_of_the_s > char_of_the_c:
                # print(ind)
                for sym in characters_of_the_s:
                    if sym == char_of_the_c:
                        # print(ind)
                        index_to_replace = ind
                        substitute = sym
                        flag = 2

            if char_of_the_s != char_of_the_c:
                break

        if flag == 0:
            print('---')
        elif flag == 1:
            # print(index_to_replace)
            where_substitute_sym = s.index(substitute, index_to_replace + 1)
            s[index_to_replace], s[where_substitute_sym] = s[where_substitute_sym], s[index_to_replace]
            print(''.join(s))
        elif flag == 2:
            s.reverse()
            where_substitute_sym = s.index(substitute)
            s.reverse()
            s[index_to_replace], s[- where_substitute_sym - 1] = s[- where_substitute_sym - 1], s[index_to_replace]

            print(''.join(s) if s < c else '---')
