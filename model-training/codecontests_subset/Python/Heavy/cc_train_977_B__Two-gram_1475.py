import sys


def solution(n, str_in):

    n_grams = []
    answer = ''
    max_count = 0
    for i in range(len(str_in) - 1):
        n_gram = str_in[i:i+2]
        if len(n_gram) == 2:
            n_grams.append(str_in[i:i+2])
    n_grams = list(set(n_grams))
    for n_gram in n_grams:
        count = 0
        for i in range(len(str_in) - 1):

            if n_gram == str_in[i:i+2]:
                count += 1
            
        if count > max_count:
            answer = n_gram
            max_count = count

    return answer


if __name__ == '__main__':
    n = sys.stdin.readline()

    while n:
        str_in = sys.stdin.readline().strip()
        print(solution(int(n), str_in))
        n = sys.stdin.readline()
