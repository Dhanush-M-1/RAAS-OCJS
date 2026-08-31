#include <bits/stdc++.h>
using namespace std;
int main(int argc, char *argv[]) {
  long long n;
  scanf("%I64d", &n);
  char stringinput[n + 1];
  long long countI = 0;
  long long countA = 0;
  long long countF = 0;
  bool flag = true;
  scanf("%s", &stringinput);
  for (long long i = 0; i < n; i++) {
    if (stringinput[i] == 'I') {
      flag = false;
      countI++;
    }
  }
  if (flag == true) {
    for (long long j = 0; j < n; j++) {
      if (stringinput[j] == 'A') countA++;
    }
  }
  if (countI > 0) {
    if (countI == 1)
      printf("%I64d", countI);
    else
      printf("%I64d", countA);
  } else
    printf("%I64d", countA);
  return 0;
}
