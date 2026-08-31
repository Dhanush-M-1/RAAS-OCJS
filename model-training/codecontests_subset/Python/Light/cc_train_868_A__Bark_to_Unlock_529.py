password = input("")
inputs_len = input("")

inputs = []
for i in range(int(inputs_len)):
    inputs.append(input(""))

for i in range(int(inputs_len)):
    if password[0] == inputs[i][0] and password[1] == inputs[i][1]:
            print("YES")
            exit(0)
    else:
        if password[0] == inputs[i][1]:
            for j in range(int(inputs_len)):
                if password[1] == inputs[j][0]:
                    print("YES")
                    exit(0)
print("NO")
