trash = int(input())

f = list(map(int, input().split(' ')))
s = list(map(int, input().split(' ')))
t = list(map(int, input().split(' ')))

t_comp = {}
for tt in t:
    if( tt in t_comp ):
        t_comp[tt] = t_comp[tt] + 1
    else:
        t_comp[tt] = 1

s_comp = {}
for ss in s:
    if( ss in s_comp ):
        s_comp[ss] = s_comp[ss] + 1
    else:
        s_comp[ss] = 1


second_error = -1
for key in s_comp:
    if (key in t_comp):
        if (s_comp[key] != t_comp[key]):
            second_error = key
            break

    if not(key in t_comp):
        second_error = key


f_comp = {}
for ff in f:
    if( ff in f_comp ):
        f_comp[ff] = f_comp[ff] + 1
    else:
        f_comp[ff] = 1


first_error = -1
for key in f_comp:
    if (key in s_comp):
        if (f_comp[key] != s_comp[key]):
            first_error = key
            break

    if not(key in s_comp):
        first_error = key


print(first_error)
print(second_error)

  	 				   	 						  	 								