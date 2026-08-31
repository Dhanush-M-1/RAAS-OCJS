#include <bits/stdc++.h>
using namespace std;
template <class T1, class T2>
ostream &operator<<(ostream &os, const pair<T1, T2> &p) {
  os << "{" << p.first << "," << p.second << "}";
  return os;
}
const int N = 3e5 + 5;
const int oo = 1e9 + 7;
int num(string s) {
  stringstream ss(s);
  int ret;
  ss >> ret;
  return ret;
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  int a = 1, b = 0, n;
  vector<string> v;
  string s, t;
  cin >> s;
  assert(s == "?");
  while (1) {
    cin >> s >> t;
    if (s == "+" or s == "-") {
      a += s == "+";
      b += s == "-";
      v.push_back(s);
      assert(t == "?");
    } else {
      assert(s == "=");
      n = num(t);
      break;
    }
  }
  if (a - n * b <= n and n * a - b >= n) {
    cout << "Possible\n";
    int now = a - b;
    vector<int> plas(a, 1);
    vector<int> minas(b, 1);
    for (int &x : plas) {
      int jog = min(max(n - now, 0), n - x);
      x += jog;
      now += jog;
    }
    for (int &x : minas) {
      int jog = min(max(now - n, 0), n - x);
      x += jog;
      now -= jog;
    }
    assert(now == n);
    a = b = 0;
    cout << plas[a++];
    for (string s : v) {
      cout << " " << s << " " << (s == "+" ? plas[a++] : minas[b++]);
    }
    cout << " = " << n << "\n";
  } else
    cout << "Impossible\n";
}
