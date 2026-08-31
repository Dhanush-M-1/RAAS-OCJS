#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007, MAX = 200001, INF = 1 << 30;
int main() {
  int N;
  cin >> N;
  string S;
  cin >> S;
  bool ok = true;
  for (int i = 1; i < N; i++) {
    if (S[i - 1] > S[i]) {
      cout << "YES" << endl;
      cout << i << " " << i + 1 << endl;
      ok = false;
    }
    if (!ok) break;
  }
  if (ok) cout << "NO" << endl;
}
