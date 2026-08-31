from sys import stdin, stdout
import cProfile

printHeap = str()
test = False
memory_constrained = False


def display(string_to_print):
    stdout.write(str(string_to_print) + "\n")


def test_print(output):
    if test:
        stdout.write(str(output) + "\n")


def display_list(list1, sep=" "):
    stdout.write(sep.join(map(str, list1)) + "\n")


def get_int():
    return int(stdin.readline())


def get_tuple():
    return map(int, stdin.readline().split())


def get_list():
    return list(map(int, stdin.readline().split()))


memory = dict()


def clear_cache():
    global memory
    memory = dict()


def cached_fn(fn, *args):
    global memory
    if args in memory:
        return memory[args]
    else:
        result = fn(*args)
        memory[args] = result
        return result


# ----------------------------------------------------------------------------------- MAIN PROGRAM


def main():
    n, ele = get_tuple()
    li = get_list()
    li.sort()
    mid = n//2
    for i in range(n):
        if li[i]>=ele:
            break
    sm = 0
    if (mid < i):
        for k in range(mid, i):
            sm += abs(li[k] - ele)
        if (i==n-1 and li[i]<ele):
            sm+= abs(li[i]-ele)
    elif (mid>=i):
        for k in range(i, mid+1):
            sm += abs(li[k] - ele)
    print(sm)


# --------------------------------------------------------------------------------------------- END


cProfile.run('main()') if test else main()