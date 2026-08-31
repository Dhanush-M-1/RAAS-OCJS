
num_error = int(input());

sum1 = sum(map(int, input().split(' ')));
sum2 = sum(map(int, input().split(' ')));
sum3 = sum(map(int, input().split(' ')));

print(sum1 - sum2);
print(sum2 - sum3);
