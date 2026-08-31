#include <bits/stdc++.h>
using namespace std;
using namespace std::chrono;
template <typename T>
void print(string name, vector<T>& v) {
  if (name.size()) cout << name << ": ";
  int s = (int)v.size();
  for (int i = (int)(0); i < (int)(s); ++i) cout << v[i] << " ";
  cout << endl;
}
template <typename T>
void print(vector<T>& v) {
  print("", v);
}
int main() {
  int test_cases = 1;
  ios::sync_with_stdio(false);
  for (int test_case = (int)(0); test_case < (int)(test_cases); ++test_case) {
    long long x[2] = {0, 0};
    long long n;
    string s;
    getline(cin, s);
    int ix = 0;
    for (int i = 0; i < (int)s.size(); i++) {
      char c = s[i];
      if (c == ' ') continue;
      if (c == '=') {
        string sv = s.substr(i + 2);
        stringstream ss;
        ss << sv;
        ss >> n;
        break;
      }
      if (c == '+')
        ix = 0;
      else if (c == '-')
        ix = 1;
      else if (c == '?')
        x[ix]++;
    }
    long long a = x[0], b = x[0] * n;
    long long c = n + x[1], d = n + x[1] * n;
    if (d < a || b < c)
      cout << "Impossible" << endl;
    else {
      cout << "Possible" << endl;
      long long u = max(a, c);
      vector<long long> res[2];
      for (int k = (int)(0); k <= (int)(1); ++k) {
        res[k] = vector<long long>(x[k]);
        long long cnt = u;
        if (k == 1) cnt = u - n;
        int ki = 0;
        while (cnt) {
          res[k][ki]++;
          cnt--;
          ki++;
          ki %= x[k];
        }
      }
      int ix = 0;
      long long cx[2] = {0, 0};
      string s2;
      for (int i = 0; i < (int)s.size(); i++) {
        char c = s[i];
        if (c != '?') s2.push_back(c);
        if (c == '+')
          ix = 0;
        else if (c == '-')
          ix = 1;
        else if (c == '?') {
          if (ix == 0) {
            stringstream ss;
            ss << res[0][cx[0]];
            s2 += ss.str();
            cx[0]++;
          } else {
            stringstream ss;
            ss << res[1][cx[1]];
            s2 += ss.str();
            cx[1]++;
          }
        }
      }
      cout << s2 << endl;
    }
  }
  return 0;
}
