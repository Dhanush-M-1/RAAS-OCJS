#include <bits/stdc++.h>
using namespace std;
struct node {
  int a, b;
  bool operator<(const node &n) const { return a < n.a; }
};
int n, m, k;
vector<unsigned long long> v, v2;
vector<char> vc;
string s;
map<char, int> mc;
int main() {
  int t, t1;
  while (cin >> n) {
    cin >> s;
    vc.clear();
    mc.clear();
    int minn = INT_MAX;
    for (int i = 0; i < s.size(); i++) {
      mc[s[i]]++;
      if (find(vc.begin(), vc.end(), s[i]) == vc.end()) {
        vc.push_back(s[i]);
      }
    }
    for (int i = 0; i < vc.size(); i++) {
      minn = min(minn, mc[vc[i]]);
    }
    string ans;
    if (minn != 0 && minn % n == 0) {
      for (int i = 0; i < vc.size(); i++) {
        int cnt = mc[vc[i]] / n;
        if (mc[vc[i]] % n != 0) {
          cout << -1 << endl;
          goto next;
        }
        for (int j = 0; j < cnt; j++) {
          ans += vc[i];
        }
      }
      string tmp;
      for (int i = 0; i < n; i++) {
        tmp += ans;
      }
      cout << tmp << endl;
    } else
      cout << -1 << endl;
  next:;
  }
  return 0;
}
