import sys,math

def read_int():
    return int(sys.stdin.readline().strip())

def read_int_list():
    return list(map(int,sys.stdin.readline().strip().split()))

def read_string():
    return sys.stdin.readline().strip()

def read_string_list(delim=" "):
    return sys.stdin.readline().strip().split(delim)

def print_list(l, delim=" "):
    print(delim.join(map(str, l)))


###### Author : Samir Vyas #######
###### Write Code Below    #######

n = read_int()
s = read_string()

counts = {"0":0, "1":0}

for _s in s:
	counts[_s] += 1

if counts["0"] != counts["1"]:
	print(1)
	print(s)
else:
	print(2)
	print(s[0],s[1:])