q = int(input())
answers = []
for i in range(q):
    l, r, d = input().split()
    l, r, d = int(l), int(r), int(d)
    if d<l:
        answers.append(d)
        continue
    else:
        s = (r//d)*d + d
        if s<=r:
            s+=d
        answers.append(s)
for i in answers:
    print(i)