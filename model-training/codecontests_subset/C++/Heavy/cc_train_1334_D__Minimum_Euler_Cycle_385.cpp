#include <bits/stdc++.h>
using namespace std;
int T;
long long N;
long long L, R;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> T;
  for (long long t = 0; t < T; t++) {
    cin >> N >> L >> R;
    if (L == N * (N - 1) + 1 && L == R) {
      cout << "1\n";
      continue;
    }
    long long ini = 0;
    long long s = 1;
    long long len = N - 1;
    while (ini + 2 * len < L) {
      ini += 2 * len;
      len--;
      s++;
    }
    ini++;
    long long first = s;
    long long second = s + 1;
    while (ini < L) {
      if (ini % 2 == 0) second++;
      if (second > N) first++, second = first + 1;
      ini++;
    }
    while (ini <= R && ini < N * (N - 1) + 1) {
      if (ini % 2)
        cout << first << " ";
      else
        cout << second << " ";
      if (ini % 2 == 0) second++;
      if (second > N) first++, second = first + 1;
      ini++;
    }
    if (R == N * (N - 1) + 1) cout << "1 ";
    cout << "\n";
  }
  return 0;
}
