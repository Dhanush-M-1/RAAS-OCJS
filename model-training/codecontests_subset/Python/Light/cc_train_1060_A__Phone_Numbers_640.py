n = int(input())
string = input()
length = len(string)
string = string.replace("8", "")
string += "8" * (length - len(string))

cnt = 0

while len(string) >= 11 and string[len(string) - 1] == "8":
    string = string.replace("8", "", 1)
    string = string[10:]
    cnt += 1

print(cnt)
