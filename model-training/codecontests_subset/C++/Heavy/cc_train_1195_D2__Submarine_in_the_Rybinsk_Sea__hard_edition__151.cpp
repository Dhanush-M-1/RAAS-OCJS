#include <bits/stdc++.h>
using namespace std;
const int MAXN = 110000;
const long long int MOD = 998244353;
long long int N, K, valore;
long long int A[MAXN];
long long int cont[50], mult[50];
void calcMult() {
  mult[0] = 1;
  for (int i = 1; i < 50; i++) {
    mult[i] = mult[i - 1] * 10;
    mult[i] %= MOD;
  }
}
int main() {
  cin >> N;
  for (int i = 0; i < N; i++) {
    cin >> A[i];
    long long int temp = A[i];
    int index = -1;
    while (temp) {
      index++;
      temp /= 10;
    }
    cont[index]++;
  }
  calcMult();
  long long int sol = 0;
  for (int i = 0; i < N; i++) {
    long long int temp = A[i];
    int index = 0;
    while (temp) {
      long long int cifra = temp % 10;
      for (int j = 0; j < 50; j++) {
        if (cont[j]) {
          if (j < index) {
            sol += cont[j] * 2 * cifra * mult[(j)*2 + 2 + (index - j - 1)];
            sol %= MOD;
          } else {
            sol += cont[j] * cifra * mult[(index)*2];
            sol %= MOD;
            sol += cont[j] * cifra * mult[(index)*2 + 1];
            sol %= MOD;
          }
        }
      }
      temp /= 10;
      index++;
    }
  }
  cout << sol;
}
