# -*- coding: utf-8 -*-
"""
@Project : 牛客网
@File    : 2.py 
@Time    : 2018/6/10 18:23
@Author  : Koushiro

B. Micro-World
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
You have a Petri dish with bacteria and you are preparing to dive into the harsh micro-world. But, unfortunately, you don't have any microscope nearby, so you can't watch them.

You know that you have
n
 bacteria in the Petri dish and size of the
i
-th bacteria is
a
i
. Also you know intergalactic positive integer constant
K
.

The
i
-th bacteria can swallow the
j
-th bacteria if and only if
a
i
>
a
j
 and
a
i
≤
a
j
+
K
. The
j
-th bacteria disappear, but the
i
-th bacteria doesn't change its size. The bacteria can perform multiple swallows. On each swallow operation any bacteria
i
 can swallow any bacteria
j
 if
a
i
>
a
j
 and
a
i
≤
a
j
+
K
. The swallow operations go one after another.

For example, the sequence of bacteria sizes
a
=
[
101
,
53
,
42
,
102
,
101
,
55
,
54
]
 and
K
=
1
. The one of possible sequences of swallows is:
[
101
,
53
,
42
,
102
,
101
––––
,
55
,
54
]

→

[
101
,
53
–––
,
42
,
102
,
55
,
54
]

→

[
101
––––
,
42
,
102
,
55
,
54
]

→

[
42
,
102
,
55
,
54
–––
]

→

[
42
,
102
,
55
]
. In total there are
3
 bacteria remained in the Petri dish.

Since you don't have a microscope, you can only guess, what the minimal possible number of bacteria can remain in your Petri dish when you finally will find any microscope.

Input
The first line contains two space separated positive integers
n
 and
K
 (
1
≤
n
≤
2
⋅
10
5
,
1
≤
K
≤
10
6
) — number of bacteria and intergalactic constant
K
.

The second line contains
n
 space separated integers
a
1
,
a
2
,
…
,
a
n
 (
1
≤
a
i
≤
10
6
) — sizes of bacteria you have.

Output
Print the only integer — minimal possible number of bacteria can remain.

Examples
inputCopy
7 1
101 53 42 102 101 55 54
outputCopy
3
inputCopy
6 5
20 15 10 15 20 25
outputCopy
1
inputCopy
7 1000000
1 1 1 1 1 1 1
outputCopy
7
Note
The first example is clarified in the problem statement.

In the second example an optimal possible sequence of swallows is:
[
20
,
15
,
10
,
15
,
20
–––
,
25
]

→

[
20
,
15
,
10
,
15
–––
,
25
]

→

[
20
,
15
,
10
–––
,
25
]

→

[
20
,
15
–––
,
25
]

→

[
20
–––
,
25
]

→

[
25
]
.

In the third example no bacteria can swallow any other bacteria.
"""

if __name__ == "__main__":
    n, K = map(int, input().split())
    bac = list(map(int, input().split()))
    bac.sort()
    diff = [0 for i in range(n-1)]
    count = 0
    future = 0
    for i in range(n-1):
        if count == 0 and bac[i + 1] - bac[i] != 0:
            diff[i] = bac[i + 1] - bac[i]
        elif count > 0:
            diff[i] = future
            count -= 1
        else:
            j = i
            tmp = bac[j]
            j = j + 1
            while bac[j] == tmp and j < n - 1:
                j += 1
            future = bac[j] - bac[i]
            diff[i] = future
            count = j - i - 1
    swallow = 0
    for i in range(n-1):
        if diff[i] <= K and diff[i] != 0:
            swallow += 1
    print(n - swallow)
