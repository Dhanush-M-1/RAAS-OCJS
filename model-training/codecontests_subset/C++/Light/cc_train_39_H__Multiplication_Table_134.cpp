#include <bits/stdc++.h>
using namespace std;
void ra(int n, int k) {
  char numero[100];
  int j, i = 0;
  while (n != 0) {
    numero[i++] = n % k + 48;
    n /= k;
  }
  i--;
  numero[i + 1] = '\0';
  char resposta[100];
  for (j = i; j >= 0; j--) {
    resposta[i - j] = numero[j];
  }
  resposta[i + 1] = '\0';
  cout << resposta << " ";
}
int main() {
  int i, j, n;
  cin >> n;
  for (i = 1; i < n; i++) {
    for (j = 1; j < n; j++) {
      ra(i * j, n);
    }
    cout << endl;
  }
}
