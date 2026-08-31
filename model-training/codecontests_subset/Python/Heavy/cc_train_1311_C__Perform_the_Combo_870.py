from sys import stdin, stdout

int_in = lambda: int(stdin.readline())
arr_in = lambda: [int(x) for x in stdin.readline().split()]
mat_in = lambda rows: [arr_in() for y in range(rows)]
str_in = lambda: stdin.readline().strip()
out = lambda o: stdout.write("{}\n".format(o))
arr_out = lambda o: out(" ".join(map(str, o)))
bool_out = lambda o: out("YES" if o else "NO")


def solve(n, m, s, p):
    mistake_at = [0]*n
    for item in p:
        mistake_at[item-1] += 1
    result = [0]*26
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    count = len(p) + 1
    for i in range(n):
        result[alphabet.index(s[i])] += count
        count -= mistake_at[i]
    return result


if __name__ == "__main__":
    for i in range(int_in()):
        n, m = arr_in()
        s = str_in()
        p = arr_in()
        arr_out(solve(n, m, s, p))