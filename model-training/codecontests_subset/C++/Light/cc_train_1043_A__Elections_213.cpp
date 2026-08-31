#include <bits/stdc++.h>
using namespace std;
const int maxn = 105;
long long re[maxn];
long long k;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  k = -1;
  long long n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> re[i];
    k = max(k, re[i]);
  }
  while (1) {
    long long aw = 0, el = 0;
    for (int i = 0; i < n; ++i) {
      aw += k - re[i];
      el += re[i];
    }
    if (aw > el) {
      cout << k << '\n';
      exit(0);
    }
    k++;
  }
}
