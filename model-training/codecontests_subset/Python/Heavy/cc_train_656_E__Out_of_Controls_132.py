from functools import reduce
from itertools import chain

n = int(input())
print(max(map(
    max,
    reduce(
        lambda a, k: reduce(
            lambda a, i: reduce(
                lambda a, j: list(chain(
                    a[:i],
                    [list(chain(
                        a[i][:j],
                        [min(a[i][j], a[i][k] + a[k][j])],
                        a[i][j+1:],
                    ))],
                    a[i+1:],
                )),
                range(n),
                a,
            ),
            range(n),
            a,
        ),
        range(n),
        list(map(
            lambda i: list(map(int, input().split())),
            range(n)))))))
