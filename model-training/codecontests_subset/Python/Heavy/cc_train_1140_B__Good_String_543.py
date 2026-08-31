def to_delete(s, n):
    # count left <-es
    l_counter = 0
    while l_counter < n and s[l_counter] != '>':
        l_counter += 1
    # count right >-es
    r_counter = 0
    while r_counter < n and s[n-1-r_counter] != '<':
        r_counter += 1
    return min(l_counter, r_counter)


#read t
t = int(input())
# read tests
tests = []
for i in range(t):
    #read n
    n = int(input())
    # read string
    s = input()
    # solve test
    tests.append((s, n))

for i in range(t):
    print(to_delete(tests[i][0], tests[i][1]))