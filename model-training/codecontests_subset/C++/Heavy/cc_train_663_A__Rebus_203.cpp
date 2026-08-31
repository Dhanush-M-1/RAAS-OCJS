#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, add = 1, sub = 0;
  string s;
  getline(cin, s);
  for (int i = 0; i < (int)s.size(); i++) {
    if (isdigit(s[i])) {
      n = stoi(s.substr(i, s.size() - i));
      break;
    } else if (s[i] == '+') {
      add++;
    } else if (s[i] == '-') {
      sub++;
    }
  }
  if (n > n * add - sub || n < add - n * sub) {
    cout << "Impossible" << endl;
    return 0;
  }
  int N = add + sub;
  cout << "Possible" << endl;
  vector<int> res(N), fl(N);
  for (int i = 2, j = 1; s[i] != '='; i += 4, j++) {
    fl[j] = s[i] == '-';
  }
  int tmp = n;
  for (int i = 0; i < N; i++) {
    if (fl[i]) {
      sub--;
      res[i] = min(n, (n * add - sub) - tmp);
      tmp += res[i];
    } else {
      add--;
      res[i] = max(1, tmp - (n * add - sub));
      tmp -= res[i];
    }
  }
  int t = 0;
  for (auto c : s) {
    if (c == '?') {
      cout << res[t++];
    } else {
      cout << c;
    }
  }
  cout << endl;
  return 0;
}
