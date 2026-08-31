# n, x, a, b = map(int, input().split())

t = int(input())
for i in range(t):
    s1, s2 = input().split()
    
    d = {}
    for symbol in s1:
        if symbol in d:
            d[symbol] += 1
        else:
            d[symbol] = 1
        
    d = {k: v for k, v in sorted(d.items(), key=lambda item: item[0])}

    # print(d)

    new_s = ''
    found = False
    for k, v in d.items():
        # print(k, v)
        for j in range(v):
            new_s += k

            if new_s != s1[:len(new_s)]:
                pos = s1[len(new_s)-1:].rfind(k)
                old_sym = s1[len(new_s) - 1]
                # print('old', old_sym)
                pos += len(new_s) - 1

                # print(new_s, s1[len(new_s):pos], old_sym, s1[pos+1:])
                ans = new_s + s1[len(new_s):pos] + old_sym + s1[pos+1:]

                if ans < s2:
                    print(ans)
                else:
                    print('---')
                found = True
                break

        if found:
            break
    if not found:
        if (s1 < s2):
            print(s1)
        else:
            print('---')


