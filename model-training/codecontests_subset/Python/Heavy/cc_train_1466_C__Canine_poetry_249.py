from string import ascii_lowercase

if __name__ == "__main__":
    n = int(input())
    for i in range(n):
        s = list(input())
        n = 0
        count = len(s)
        j = -1
        while j < count:
            j += 1
            if j == count:
                break
            first = j > 0 and s[j] == s[j - 1]
            second = j > 1 and s[j] == s[j - 2]  # or (j > s[j] == s[j-1]):
            if first or second:
                for new_sym in ascii_lowercase:
                    if not ((j > 0 and new_sym == s[j - 1]) or (j > 1 and new_sym == s[j - 1]) or (
                            j < count - 1 and new_sym == s[j + 1]) or (j < count - 2 and new_sym == s[j + 2])):
                        n += 1
                        s[j] = new_sym
                        break
        print(n)
