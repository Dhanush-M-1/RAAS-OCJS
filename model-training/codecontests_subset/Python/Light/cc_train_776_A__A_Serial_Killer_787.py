str1, str2 = map(str, input().split())
n = int(input())
dict1 = {}
for x in range(n):
    str3, str4 = map(str, input().split())
    dict1[str3] = str4
print(str1, str2)
for key, values in dict1.items():
    if (key == str1):
        str1 = values
        print(str1, str2)
    else:
        str2 = values
        print(str1, str2)
