def freq_twograms(s):
    LATIN_CNT = len("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    ORD_A = ord('A')
    s = [ord(c) - ORD_A for c in s]
    # Use a frequency matrix
    freq_mat = [[0 for _ in range(LATIN_CNT)] for _ in range(LATIN_CNT)]
    max_freq = 0
    max_freq_i1 = 0
    max_freq_i2 = 0
    for i in range(len(s) - 1):
        i1 = s[i]; i2 = s[i + 1]
        freq = freq_mat[i1][i2]; freq += 1; freq_mat[i1][i2] = freq
        if max_freq < freq:
            max_freq = freq
            max_freq_i1 = i1
            max_freq_i2 = i2
    return (chr(max_freq_i1 + ORD_A) + chr(max_freq_i2 + ORD_A))

l = int(input(""))
s = input("")
print(freq_twograms(s))
