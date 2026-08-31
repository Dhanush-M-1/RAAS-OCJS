X, Total = list(map(int, input().split())), 0
if X[1] > X[0]:
    print(X[0])
    exit()
Total, X[0] = Total + X[1], X[0] - X[1]
while X[0] // (X[1] - 1) >= 1:
    Total, X[0] = Total + X[1], X[0] - X[1] + 1
print(Total + X[0] + 1)

# UB_CodeForces
# Advice: Don't limit your challenge, challenge your limits
# Location: Behind my desk next my quince lemon tea
# Caption: It's beautiful day and I want to make it perfect
# CodeNumber: 455
