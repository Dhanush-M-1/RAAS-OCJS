def compilation_error (init,first,secon):
    ans = []
    first.append(0)
    for a,b in zip(init,first):
        if a != b :
            ans.append(str(a))
            break
    first.pop(-1)
    secon.append(0)
    for x,y in zip(first,secon):
        if x != y :
            ans.append(str(x))
            break
    return ans



t = int(input())
init = list(map(int,input().split()))
init = sorted(init)
first = list(map(int,input().split()))
first = sorted(first)
secon = list(map(int,input().split()))
secon = sorted(secon)
print ("\n".join(compilation_error(init,first,secon)))
