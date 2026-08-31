def get_even(n_list):
    return sorted([n for n in n_list if not n % 2], reverse=True)

def get_odd(n_list):
    return sorted([n for n in n_list if n % 2], reverse=True)

def solve(n_list):
    
    even = get_even(n_list)
    odd = get_odd(n_list)

    le, lo = len(even), len(odd)
    
    if le > lo + 1:
        return sum(even[lo + 1:])
    elif lo > le + 1:
        return sum(odd[le + 1:])
    else:
        return 0


_ = input()
s_list = input()
n_list = list(map(int, s_list.split(' ')))

print(solve(n_list))