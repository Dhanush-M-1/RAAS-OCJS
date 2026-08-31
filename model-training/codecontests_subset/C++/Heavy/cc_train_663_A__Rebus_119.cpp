#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  long long N;
  string s;
  vector<int> a, b(1);
  while (cin >> s) {
    if (s[0] == '?') {
      a.push_back(1);
    } else if (s[0] == '=') {
      cin >> N;
      break;
    } else {
      b.push_back(s[0] == '-');
    }
  }
  long long p = count(b.begin(), b.end(), 0);
  if (p - N * (b.size() - p) > N || N * p - (b.size() - p) < N) {
    cout << "Impossible\n";
    return 0;
  }
  long long cur = 2ll * p - b.size();
  while (cur != N) {
    if (cur > N) {
      for (int i = 0; i < a.size(); i++) {
        if (b[i] && a[i] < N) {
          long long diff = min(N - a[i], cur - N);
          a[i] += diff;
          cur -= diff;
        }
      }
    } else {
      for (int i = 0; i < a.size(); i++) {
        if (!b[i] && a[i] < N) {
          long long diff = min(N - a[i], N - cur);
          a[i] += diff;
          cur += diff;
        }
      }
    }
  }
  cout << "Possible\n";
  for (int i = 0; i < a.size(); i++) {
    cout << a[i] << ' ';
    if (i + 1 != a.size()) cout << (b[i + 1] ? "- " : "+ ");
  }
  cout << "= " << N;
  return 0;
}
