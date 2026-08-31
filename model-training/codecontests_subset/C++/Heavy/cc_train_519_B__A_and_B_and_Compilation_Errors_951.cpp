#include <bits/stdc++.h>
using namespace std;
int findDiffer(vector<long long> a, vector<long long> b) {
  long long v{0};
  for (int i = 0; i < a.size(); ++i) {
    if (a[i] != b[i]) {
      v = a[i];
      break;
    }
  }
  return v;
}
long long n;
void in() { cin >> n; }
void out() {
  vector<long long> a(n), b(n - 1), c(n - 2);
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) cin >> b[i];
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  long long a1, a2;
  a1 = findDiffer(a, b);
  a2 = findDiffer(b, c);
  cout << a1 << "\n" << a2;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t = 1;
  while (t--) {
    in();
    out();
  }
  return 0;
}
