#include <bits/stdc++.h>
using namespace std;
int main() {
  int N;
  scanf("%d", &N);
  long long Suma = 0;
  long long SumaCheck = 0;
  for (int i = 0; i < N; i++) {
    long long temp;
    scanf("%I64d", &temp);
    Suma += temp;
  }
  for (int i = 0; i < N - 1; i++) {
    long long temp;
    scanf("%I64d", &temp);
    SumaCheck += temp;
  }
  printf("%I64d\n", Suma - SumaCheck);
  Suma = SumaCheck;
  SumaCheck = 0;
  for (int i = 0; i < N - 2; i++) {
    long long temp;
    scanf("%I64d", &temp);
    SumaCheck += temp;
  }
  printf("%I64d", Suma - SumaCheck);
  return 0;
}
