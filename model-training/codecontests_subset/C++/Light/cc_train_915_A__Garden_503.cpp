#include <bits/stdc++.h>
using namespace std;
int i, n, m, t, s, v, vedro[105];
int main() {
  cin >> v >> s;
  for (i = 0; i < v; i++) {
    cin >> vedro[i];
  }
  sort(vedro, vedro + v);
  for (i = v - 1; i >= 0; i--) {
    if (s % vedro[i] == 0) {
      cout << s / vedro[i];
      return 0;
    }
  }
}
